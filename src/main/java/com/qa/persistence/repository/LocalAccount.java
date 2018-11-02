package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.List;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONTools;

@Alternative
public class LocalAccount implements Accountable{
	
	private HashMap<Integer, Classroom> classrooms = new HashMap<Integer, Classroom>();

	public String getAllInRoom(int classroomID) {
		Classroom thisRoom = classrooms.get(classroomID);
		return JSONTools.JSONroom(thisRoom);
	}

	public String getAllInAllRooms() {
		//List<Classroom> allRooms = classrooms.values().
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
