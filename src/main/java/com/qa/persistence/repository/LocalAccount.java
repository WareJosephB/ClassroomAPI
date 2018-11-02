package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.List;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Classroom;

import com.qa.persistence.domain.Student;
import com.qa.persistence.domain.Trainer;

import com.qa.util.JSONTools;

@Alternative
public class LocalAccount implements Accountable {

	private HashMap<Integer, Classroom> classrooms = new HashMap<Integer, Classroom>();

	private HashMap<Integer, Trainer> trainers = new HashMap<Integer, Trainer>();
	private HashMap<Integer, Student> students = new HashMap<Integer, Student>();

	private static int trainerKey = 1;
	private static int studentKey = 1;
	private static int roomKey = 1;

	public String getAllInRoom(int classroomID) {
		Classroom thisRoom = classrooms.get(classroomID);
		return JSONTools.JSONfromObject(thisRoom);
	}

	public String getAllInAllRooms() {
		return JSONTools.JSONfromObject(classrooms);
	}

	public String getTrainerByClassroom(int classRoom) {
		return JSONTools.JSONfromObject(classrooms.get(classRoom).getRoomLead());
	}

	public String getAllTrainersByClassroom(int classRoom) {
		List<Trainer> trainers = classrooms.get(classRoom).getAssistants();
		trainers.add(classrooms.get(classRoom).getRoomLead());
		return JSONTools.JSONfromObject(trainers);
	}

	public String getAllTrainers() {
		return JSONTools.JSONfromObject(trainers.values());
	}

	public String getTrainerByID(int idNumber) {
		return JSONTools.JSONfromObject(trainers.get(idNumber));
	}

	public String getStudents() {
		return JSONTools.JSONfromObject(students.values());
	}

	public String getStudentsByClassroom(int classRoom) {
		return JSONTools.JSONfromObject(classrooms.get(classRoom).getStudents());
	}

	public String getStudentByID(int idNumber) {
		return JSONTools.JSONfromObject(students.get(idNumber));
	}

	public boolean addTrainer(String trainer) {
		Trainer trainerObject = JSONTools.ObjectFromJSON(trainer, Trainer.class);
		trainerObject.setID(trainerKey);
		trainers.put(trainerKey, trainerObject);
		trainerKey++;
		return true;
	}

	public boolean addClassroom(String classroom) {
		Classroom classRoomObject = JSONTools.ObjectFromJSON(classroom, Classroom.class);
		classRoomObject.setID(trainerKey);
		classrooms.put(roomKey, classRoomObject);
		roomKey++;
		return true;

	}

	@Override
	public boolean addStudent(String student) {
		Student traineeObject = JSONTools.ObjectFromJSON(student, Student.class);
		traineeObject.setID(studentKey);
		students.put(studentKey, traineeObject);
		studentKey++;
		return true;

	}

	@Override
	public Classroom ClassroomByID(int classID) {
		return classrooms.get(classID);
	}

	@Override
	public List<Trainer> AssistantsByID(int classID) {
		return classrooms.get(classID).getAssistants();
	}

	@Override
	public Student StudentByID(int idNumber) {
		return students.get(idNumber);
	}

	@Override
	public Trainer TrainerByID(int idNumber) {
		return trainers.get(idNumber);
	}

	@Override
	public boolean removeStudent(int idNumber) {
		if (students.get(idNumber) != null) {
			students.remove(idNumber);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean removeTrainer(int idNumber) {
		if (trainers.get(idNumber) != null) {
			trainers.remove(idNumber);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean removeClassroom(int idNumber) {
		if (classrooms.get(idNumber) != null) {
			classrooms.remove(idNumber);
			return true;
		} else {
			return false;
		}
	}


}
