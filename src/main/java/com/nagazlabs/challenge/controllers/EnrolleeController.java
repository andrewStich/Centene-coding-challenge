package com.nagazlabs.challenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagazlabs.challenge.models.Dependent;
import com.nagazlabs.challenge.models.Enrollee;
import com.nagazlabs.challenge.services.EnrolleeService;

@RestController
public class EnrolleeController {

	@Autowired
	private EnrolleeService enrolleeService;
	
	@GetMapping(value = "/enrollee/get/{id}")
	public Enrollee getEnrolleeById(@PathVariable(value = "id") int id) {
		return enrolleeService.getEnrolleeById(id);
	}
	
	@GetMapping(value = "/enrollee/admin/getAll")
	public List<Enrollee> getAllEnrollees() {
		return enrolleeService.getAllEnrollees();
	}
	
	@PostMapping(value = "/enrollee/add")
	public Enrollee addEnrollee(@RequestBody Enrollee enrollee) {
		return enrolleeService.addEnrollee(enrollee);
	}
	
	@PostMapping(value = "/enrollee/add/dependent")
	public boolean addDependent(@RequestBody Enrollee enrollee, @RequestBody Dependent dependent) {
		return enrolleeService.addDependent(enrollee, dependent);
	}
	
	@PutMapping(value = "/enrollee/update")
	public Enrollee updateEnrollee(@RequestBody Enrollee enrollee) {
		return enrolleeService.updateEnrollee(enrollee);
	}
	
	@DeleteMapping(value = "/enrollee/delete")
	public boolean deleteEnrollee(@RequestBody Enrollee enrollee) {
		return enrolleeService.deleteEnrollee(enrollee);
	}
	
	@DeleteMapping(value = "/enrollee/delete/dependent")
	public boolean deleteDependent(@RequestBody Enrollee enrollee, @RequestBody Dependent dependent) {
		return enrolleeService.deleteDependent(enrollee, dependent);
	}
	
	@DeleteMapping(value = "/enrollee/admin/deleteAll")
	public void deleteAllEnrollees() {
		enrolleeService.deleteAllEnrollees();
	}
}
