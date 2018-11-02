package com.qa.persistence.repository;

import java.util.List;

import javax.enterprise.inject.Default;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainee;
import com.qa.persistence.domain.Trainer;

@Default
public class RemoteAccount implements Accountable {
	
	public String getAllInRoom(int classRoom) {
		return com.qa.util.JSONTools.JSONfromObject(ClassroomByID(classRoom));
	}

	public String getAllInAllRooms() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTrainerByClassroom(int classRoom) {
		return com.qa.util.JSONTools.JSONfromObject(ClassroomByID(classRoom).getRoomLead());
	}

	public String getAllTrainersByClassroom(int classRoom) {
		List<Trainer> inRoom = ClassroomByID(classRoom).getAssistants();
		inRoom.add(ClassroomByID(classRoom).getRoomLead());
		return com.qa.util.JSONTools.JSONfromObject(inRoom);
	}

	public String getAllTrainers() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTrainerByID(int idNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getStudentsByClassroom(int classRoom) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getStudentByID(int idNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addStudent(String student) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addTrainer(String trainer) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addClassroom(String classroom) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Classroom ClassroomByID(int classID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trainer> AssistantsByID(int classID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trainee StudentByID(int idNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trainer TrainerByID(int idNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
