package com.qa.persistence.repository;

public interface Accountable {
	
	public String getAllInRoom(int classRoom);
	
	public String getAllInAllRooms();
	
	public String getTrainerByClassroom(int classRoom);
	
	public String getAllTrainersByClassroom(int classRoom);
	
	public String getAllTrainers();
	
	public String getTrainerByID(int idNumber);
	
	public String getStudents();
	
	public String getStudentsByClassroom(int classRoom);
	
	public String getStudentByID(int idNumber);

}
