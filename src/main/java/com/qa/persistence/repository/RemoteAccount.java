package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.domain.Person;
import com.qa.persistence.domain.Student;
import com.qa.persistence.domain.Trainer;
import com.qa.util.JSONTools;

@Default
@Transactional(SUPPORTS)
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
	@Transactional(REQUIRED)
	public boolean addStudent(String student) {
		Student traineeObject = JSONTools.ObjectFromJSON(student, Student.class);
		entityManager.persist(traineeObject);
		return true;
	}
	@Transactional(REQUIRED)
	public boolean addTrainer(String trainer) {
		Trainer trainerObject = JSONTools.ObjectFromJSON(trainer, Trainer.class);
		entityManager.persist(trainerObject);
		return true;

	}
	@Transactional(REQUIRED)
	public boolean addClassroom(String classroom) {
		Classroom classroomObject = JSONTools.ObjectFromJSON(classroom, Classroom.class);
		entityManager.persist(classroomObject);
		return true;
	}

	public Classroom ClassroomByID(int classID) {
		return (Classroom) entityManager
				.createQuery("SELECT i FROM trainer i WHERE i.roomNumber =" + Integer.toString(classID))
				.getSingleResult();
	}

	public List<Trainer> AssistantsByID(int classID) {
		return entityManager.createQuery("SELECT i FROM trainer i WHERE i.roomNumber =" + Integer.toString(classID))
				.getResultList();
	}

	@Override
	public Student StudentByID(int idNumber) {
		return (Student) entityManager.createQuery("SELECT i FROM trainee i WHERE i.id =" + Integer.toString(idNumber))
				.getSingleResult();
	}

	public Trainer TrainerByID(int idNumber) {
		return (Trainer) entityManager.createQuery("SELECT i FROM trainer i WHERE i.id =" + Integer.toString(idNumber))
				.getSingleResult();
	}

	@Transactional(REQUIRED)
	public boolean removeStudent(int idNumber) {
		Student student = entityManager.find(Student.class, idNumber);
		if (student != null) {
			entityManager.remove(student);
			return true;
		} else {
			return false;
		}
	}

	@Transactional(REQUIRED)
	public boolean removeTrainer(int idNumber) {
		Trainer trainer = entityManager.find(Trainer.class, idNumber);
		if (trainer != null) {
			entityManager.remove(trainer);
			return true;
		} else {
			return false;
		}
	}

	@Transactional(REQUIRED)
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
