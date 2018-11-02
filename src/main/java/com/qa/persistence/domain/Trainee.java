package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {
	
	public Trainee(String name) {
		this.name = name;
		
}
	
	private String name;
	private int technicalSkills;
	private int softSkills;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int classRoomid;
	
}
