package com.qa.persistence.repository;

import java.util.Map;

import javax.enterprise.inject.Alternative;

@Alternative
public class LocalAccount implements Accountable{
	
	private Map classrooms = new HashMap<int, Classroom>();

	public String getAllInRoom(int classRoom) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAllInAllRooms() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTrainerByClassroom(int classRoom) {
		// TODO Auto-generated method stub
		return null;
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

}
