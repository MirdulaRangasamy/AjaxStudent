package com.exterro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import com.exterro.dao.StudentDao;
import com.exterro.entity.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("studentManagement")
public class StudentController {
	private ObjectMapper mapper = new ObjectMapper();
	private StudentDao studDao = new StudentDao();
	
	@Context
	private HttpServletRequest request;
	
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})	
	public Response addStudent(String stud) throws JsonMappingException, JsonProcessingException{
		HttpSession session = request.getSession();
		System.out.println(session);
		Student student = mapper.readValue(stud, Student.class);
		Student student1 = studDao.addStudent(student);
		
		NewCookie[] nn = {new NewCookie("sroll",""+student.getRollNo()),new NewCookie("sname",student.getName())};
		System.out.println(session);
		return Response.ok().entity(student1).cookie(nn).build();
	}
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})		
	public Response updateStudent(String stud) throws JsonMappingException, JsonProcessingException{
		HttpSession session = request.getSession();
		System.out.println(session);
		Student student = mapper.readValue(stud, Student.class);
		Student student1 = studDao.updateStudent(student);
		return Response.ok().entity(student1).build();
	}
	
	@GET
	@Path("student/{rollno1}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getStudent(@PathParam("rollno1") String rollno1){
		System.out.println(rollno1);
		Student student1 = studDao.getStudent(Integer.parseInt(rollno1));
		System.out.println(student1);
		return Response.ok().entity(student1).build();
	}
	
	@GET
	@Produces({MediaType.TEXT_PLAIN})	
	public Response getAllStudent(){
		List<Student> studList = studDao.getAllStudents();
		return Response.ok().entity(studList.toString()).build();
	}
	
	@DELETE
	@Path("/{rollno}")
	@Produces({MediaType.TEXT_PLAIN})	
	public Response deleteStudent(@PathParam("rollno") int rollNo){
		String result = studDao.deleteStudent(rollNo);
		return Response.ok().entity(result).build();
	}
}
