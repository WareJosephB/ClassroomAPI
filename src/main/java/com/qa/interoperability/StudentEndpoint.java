package com.qa.interoperability;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.persistence.repository.Accountable;

@Path("/Student")
public class StudentEndpoint {
	
	@Inject
	private Accountable service;
	
	
	@Path("/create/")
	@POST
	@Produces({ "application/json" })
	public String addStudent(String student) {
		if (service.addStudent(student)) {
			return "Student addedd succesfully";
		} else {
			return "Error adding Student";
		}
	}
	
	@Path("/delete/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String removeStudent(@PathParam("id") int id) {
		if (service.removeStudent(id)) {
			return "Student removed succesfully";
		} else {
			return "Problem removing student";
		}
	}
	
	@Path("/getStudents/{id}")
	@GET
	@Produces({ "application/json" })
	public String getStudentByID(@PathParam("id") int id) {
		return (service.getStudentByID(id));
	}
	
	@Path("/getStudents")
	@GET
	@Produces({ "application/json" })
	public String getStudents() {
		return (service.getStudents());
	}
	
}
