package com.qa.persistence.repository;

import java.util.List;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Trainer;
import com.qa.persistence.domain.Trainee;

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

	public void addStudent(String student);

	public void addTrainer(String trainer);

	public void addClassroom(String classroom);

	public boolean removeStudent(String student);

	public boolean removeStudent(int idNumber);

	public boolean removeTrainer(String trainer);

	public boolean removeTrainer(int idNumber);

	public boolean removeClassroom(String classRoom);

	public boolean removeClassroom(int idNumber);

	public Classroom ClassroomByID(int classID);

	public List<Trainer> AssistantsByID(int classID);

	public Trainee StudentByID(int idNumber);

	public Trainer TrainerByID(int idNumber);

}
