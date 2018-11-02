package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.Path;

import com.qa.persistence.repository.Accountable;

@Path("/classroom")
public class ClassRoomEndpoint {
	
	@Inject
	private Accountable service;
	
	@Path("/get")
	
}
