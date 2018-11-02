package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.persistence.repository.Accountable;

@Path("/Trainer")
public class TrainerEndpoint {
	
	@Inject
	private Accountable service;
	
	
	@Path("/create/")
	@POST
	@Produces({ "application/json" })
	public String addTrainer(String student) {
		if (service.addTrainer(student)) {
			return "Trainer added succesfully";
		} else {
			return "Error adding trainer";
		}
	}
	
	@Path("/delete/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String removeTrainer(@PathParam("id") int id) {
		if (service.removeTrainer(id)) {
			return "Trainer removed succesfully";
		} else {
			return "Problem removing trainer";
		}
	}
	
	@Path("/getTrainers/{id}")
	@GET
	@Produces({ "application/json" })
	public String getTrainerByID(@PathParam("id") int id) {
		return (service.getTrainerByID(id));
	}
	
	@Path("/getTrainers")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainers() {
		return (service.getAllTrainers());
	}
	
}
