package com.qa.persistence.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Classroom {

	public Classroom(Trainer roomLead, List<Trainee> students) {
		this.roomLead = roomLead;
		this.students = students;
	}

	public Classroom(Trainer roomLead, List<Trainer> teachingAssistants, List<Trainee> students) {
		this(roomLead, students);
		this.teachingAssistants = teachingAssistants;
	}

	public void addTrainee(Trainee trainee) {
		this.students.add(trainee);
	}

	public boolean removeTrainee(Trainee trainee) {
		return this.students.remove(trainee);
	}

	public void addAssistant(Trainer assistant) {
		this.teachingAssistants.add(assistant);
	}

	public boolean removeAssistant(Trainer assistant) {
		return this.teachingAssistants.remove(assistant);
	}

	public void replaceRoomlead(Trainer trainer) {
		this.roomLead = trainer;
		this.removeAssistant(trainer);
	}

	public Trainer getRoomLead() {
		return this.roomLead;
	}

	public List<Trainee> getStudents() {
		return this.students;
	}

	public List<Trainer> getAssistants() {
		return this.teachingAssistants;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="roomNumber")
	private int roomNumber;
	private Trainer roomLead;
	private List<Trainee> students;
	private List<Trainer> teachingAssistants;

	public void setID(int roomKey) {
		this.roomNumber = roomKey;
	}

}
