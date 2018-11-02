package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//@Entity
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
public class Student extends Person{
		
	public Student(String name) {
		this.setName(name);
	}

	public Student(String name, int classRoomid) {
		this(name);
		this.setClassRoomid(classRoomid);

	}

	public int getTechnicalSkills() {
		return this.technicalSkills;
	}

	public void setTechnicalSkills(int technicalSkills) {
		this.technicalSkills = technicalSkills;
	}

	public int getSoftSkills() {
		return this.softSkills;
	}

	public void setSoftSkills(int softSkills) {
		this.softSkills = softSkills;
	}

	public int getClassRoomid() {
		return this.classRoomid;
	}

	public void setClassRoomid(int classRoomid) {
		this.classRoomid = classRoomid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setID(int id) {
		this.id = id;
	}


	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(optional=false, fetch = FetchType.EAGER, targetEntity = Classroom.class) 
	private int classRoomid;
	private String name;
	private int technicalSkills;
	private int softSkills;

}
