package com.qa.persistence.repository;

public interface Accountable {
	
	public String getAllInRoom(int classroom);
	
	public String getAllInAllRooms();
	
	public String getTrainerByClassroom(int classroom);
	
	public String getAllTrainersByClassroom(int classroom);
	
	public String getAllTrainers();
	
	public String getTrainerByID(int idNumber);
	
	public String getStudents();
	
	public String getStudentsByClassroom(int classroom);
	
	public String getStudentByID(int idNumber);
	
	public boolean addStudent(String student);
	
	public boolean addTrainer(String trainer);
	
	public boolean addClassroom(String classroom);

}
