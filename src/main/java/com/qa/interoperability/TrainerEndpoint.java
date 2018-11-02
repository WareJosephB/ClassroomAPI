package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.Path;

import com.qa.persistence.repository.Accountable;

@Path("/Trainer")
public class TrainerEndpoint {
	
	@Inject
	private Accountable service;
	
	
}
