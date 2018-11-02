package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Person;
import com.qa.persistence.domain.Trainee;
import com.qa.persistence.domain.Trainer;
import com.qa.util.JSONTools;

@Default
public class RemoteAccount implements Accountable {

	@PersistenceContext(unitName = "primary")
	private static EntityManager entityManager;

	public String getAllInRoom(int classRoom) {
		return com.qa.util.JSONTools.JSONfromObject(ClassroomByID(classRoom));
	}

	public String getAllInAllRooms() {
		List<Person> allPeople = new ArrayList<Person>();
		allPeople.addAll(entityManager.createQuery("SELECT a FROM Trainer a").getResultList());
		allPeople.addAll(entityManager.createQuery("SELECT a FROM Trainee a").getResultList());
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
		Query query = entityManager.createQuery("SELECT a FROM Trainer a");
		return JSONTools.JSONfromObject(query.getResultList());
	}

	public String getTrainerByID(int idNumber) {
		return JSONTools.JSONfromObject(TrainerByID(idNumber));
	}

	public String getStudents() {
		Query query = entityManager.createQuery("SELECT a FROM Trainee a");
		return JSONTools.JSONfromObject(query.getResultList());
	}

	public String getStudentsByClassroom(int classRoom) {
		Query query = entityManager
				.createQuery("SELECT i FROM trainee i WHERE i.roomNumber =" + Integer.toString(classRoom));
		return JSONTools.JSONfromObject(query.getResultList());
	}

	public String getStudentByID(int idNumber) {
		return JSONTools.JSONfromObject(StudentByID(idNumber));
	}

	public boolean addStudent(String student) {
		Trainee traineeObject = JSONTools.ObjectFromJSON(student, Trainee.class);
		entityManager.persist(traineeObject);
		return true;
	}

	public boolean addTrainer(String trainer) {
		Trainer trainerObject = JSONTools.ObjectFromJSON(trainer, Trainer.class);
		entityManager.persist(trainerObject);
		return true;

	}

	public boolean addClassroom(String classroom) {
		Classroom classroomObject = JSONTools.ObjectFromJSON(classroom, Classroom.class);
		entityManager.persist(classroomObject);
		return true;
	}

	@Override
	public Classroom ClassroomByID(int classID) {
		return (Classroom) entityManager
				.createQuery("SELECT i FROM trainer i WHERE i.roomNumber =" + Integer.toString(classID))
				.getSingleResult();
	}

	@Override
	public List<Trainer> AssistantsByID(int classID) {
		return entityManager.createQuery("SELECT i FROM trainer i WHERE i.roomNumber =" + Integer.toString(classID))
				.getResultList();
	}

	@Override
	public Trainee StudentByID(int idNumber) {
		return (Trainee) entityManager.createQuery("SELECT i FROM trainee i WHERE i.id =" + Integer.toString(idNumber))
				.getSingleResult();
	}

	@Override
	public Trainer TrainerByID(int idNumber) {
		return (Trainer) entityManager.createQuery("SELECT i FROM trainer i WHERE i.id =" + Integer.toString(idNumber))
				.getSingleResult();
	}

	@Override
	public boolean removeStudent(int idNumber) {
		Trainee student = entityManager.find(Trainee.class, idNumber);
		if (student != null) {
			entityManager.remove(student);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean removeTrainer(int idNumber) {
		Trainer trainer = entityManager.find(Trainer.class, idNumber);
		if (trainer != null) {
			entityManager.remove(trainer);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean removeClassroom(int idNumber) {
		Classroom classroom = entityManager.find(Classroom.class, idNumber);
		if (classroom != null) {
			entityManager.remove(classroom);
			return true;
		} else {
			return false;
		}
	}

}
