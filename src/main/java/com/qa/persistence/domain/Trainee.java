package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class Trainee {

	public Trainee(String name) {
		this.setName(name);
	}

	public Trainee(String name, int classRoomid) {
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

	private String name;
	private int technicalSkills;
	private int softSkills;
	@Id
	@GeneratedValue()
	private int id;
	private int classRoomid;

}
