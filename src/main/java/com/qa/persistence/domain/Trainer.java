package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Trainer {

	public Trainer(String name) {
		this.name = name;
	}
	
	@Id @GeneratedValue()
	private int id;
	private String name;
	//private int classRoomid;

	
}
