package com.qa.persistence.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classroom {

	public Classroom(Trainer roomLead, List<Student> students) {
		this.roomLead = roomLead;
		this.students = students;
	}

	public Classroom(Trainer roomLead, List<Trainer> teachingAssistants, List<Student> students) {
		this(roomLead, students);
		this.teachingAssistants = teachingAssistants;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public boolean removeStudent(Student student) {
		return this.students.remove(student);
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

	public List<Student> getStudents() {
		return this.students;
	}

	public List<Trainer> getAssistants() {
		return this.teachingAssistants;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomNumber;
	private Trainer roomLead;
	private List<Student> students;
	private List<Trainer> teachingAssistants;

	public void setID(int roomKey) {
		this.roomNumber = roomKey;
	}

}
