package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.List;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Classroom;

import com.qa.persistence.domain.Trainee;
import com.qa.persistence.domain.Trainer;

import com.qa.util.JSONTools;


@Alternative
public class LocalAccount implements Accountable{
	
	private HashMap<Integer, Classroom> classrooms = new HashMap<Integer, Classroom>();

	private HashMap<Integer, Trainer> trainers = new HashMap<Integer, Trainer>();
	private HashMap<Integer, Trainee> students = new HashMap<Integer, Trainee>();


	public String getAllInRoom(int classroomID) {
		Classroom thisRoom = classrooms.get(classroomID);
		return JSONTools.JSONroom(thisRoom);
	}

	public String getAllInAllRooms() {
		//List<Classroom> allRooms = classrooms.values().
		return null;
	}

	public String getTrainerByClassroom(int classRoom) {
		return classrooms.get(classRoom).getRoomLead();
	}

	public String getAllTrainersByClassroom(int classRoom) {
		// TODO Auto-generated method stub
		return null;
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
		return classrooms.get(classID);
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
