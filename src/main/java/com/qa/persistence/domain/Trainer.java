package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Trainer {

	public Trainer(String name) {
		this.setName(name);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne(optional=true, fetch = FetchType.LAZY) 
    @JoinColumn(name="fk_roomNumber", nullable=false)
	private int classRoomid;

	public void setID(int trainerKey) {
		this.id = trainerKey;

	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
