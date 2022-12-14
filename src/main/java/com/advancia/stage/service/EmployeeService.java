package com.advancia.stage.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.advancia.stage.dao.Dao;
import com.advancia.stage.model.Employee;

@Path("/employees")
public class EmployeeService {

	// URI:
	// /contextPath/servletPath/employees
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Employee> getEmployees_JSON() {
		List<Employee> listOfCountries = Dao.getAllEmployees();
		return listOfCountries;
	}

	// URI:
	// /contextPath/servletPath/employees/{empNo}
	@GET
	@Path("/{empNo}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee getEmployee(@PathParam("empNo") String empNo) {
		return Dao.getEmployee(empNo);
	}

	// URI:
	// /contextPath/servletPath/employees
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee addEmployee(Employee emp) {
		return Dao.addEmployee(emp);
	}

	// URI:
	// /contextPath/servletPath/employees
	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Employee updateEmployee(Employee emp) {
		return Dao.updateEmployee(emp);
	}

	@DELETE
	@Path("/{empNo}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void deleteEmployee(@PathParam("empNo") String empNo) {
		Dao.deleteEmployee(empNo);
	}

}
