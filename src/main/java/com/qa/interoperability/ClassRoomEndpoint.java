package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.persistence.repository.Accountable;

@Path("/classroom")
public class ClassRoomEndpoint {

	@Inject
	private Accountable service;

	@Path("/create/")
	@POST
	@Produces({ "application/json" })
	public String addClassroom(String classroom) {
		if (service.addClassroom(classroom)) {
			return "Room addedd succesfully";
		} else {
			return "Error adding room";
		}
	}

	@Path("/delete/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteRoom(@PathParam("id") int id) {
		if (service.removeClassroom(id)) {
			return "Room deleted succesfully";
		} else {
			return "Problem deleting room";
		}
	}

	@Path("/getRoom/{id}")
	@GET
	@Produces({ "application/json" })
	public String ClassroomByID(@PathParam("id") int id) {
		return (service.getAllInRoom(id));
	}
	
	@Path("/getRoom/{id}/Students")
	@GET
	@Produces({ "application/json" })
	public String StudentsByRoom(@PathParam("id") int id) {
		return (service.getStudentsByClassroom(id));
	}

	@Path("/getRoom/")
	@GET
	@Produces({ "application/json" })
	public String allClassrooms() {
		return (service.getAllInAllRooms());
	}

	public void setService(Accountable service) {
		this.service = service;
	}

	@Path("/getRoom/{id}/Lead")
	@GET
	@Produces({ "application/json" })
	public String roomLeadByID(@PathParam("id") int id) {
		return (service.getTrainerByClassroom(id));
	}
	
	@Path("/getRoom/{id}/AllTrainers")
	@GET
	@Produces({ "application/json" })
	public String TrainersByRoom(@PathParam("id") int id) {
		return (service.getAllTrainersByClassroom(id));
	}

}
