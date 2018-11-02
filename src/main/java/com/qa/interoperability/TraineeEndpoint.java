package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.Path;

import com.qa.persistence.repository.Accountable;

@Path("/Trainee")
public class TraineeEndpoint {
	
	@Inject
	private Accountable service;
	
	
}
