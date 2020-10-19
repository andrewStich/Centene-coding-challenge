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
import com.nagazlabs.challenge.services.DependentService;

@RestController
public class DependentController {

	@Autowired
	private DependentService dependentService;
	
	@GetMapping(value = "/dependent/get/{id}")
	public Dependent getDependent(@PathVariable(value = "id") int id) {
		return dependentService.getDependentById(id);
	}
	
	@GetMapping(value = "/dependent/get/enrollee/{id}")
	public List<Dependent> getEnrolleeDependents(@PathVariable(value = "id") int id) {
		return dependentService.getEnrolleeDependents(id);
	}
	
	@GetMapping(value = "/dependent/admin/getAll")
	public List<Dependent> getAllDependents() {
		return dependentService.getAllDependents();
	}
	
	@PostMapping(value = "/dependent/add")
	public Dependent addDependent(@RequestBody Dependent dependent) {
		return dependentService.addDependent(dependent);
	}
	
	@PutMapping(value = "/dependent/update")
	public boolean updateDependent(@RequestBody Dependent dependent) {
		return dependentService.updateDependent(dependent);
	}
	
	@DeleteMapping(value = "/dependent/delete")
	public boolean deleteDependent(@RequestBody Dependent dependent) {
		return dependentService.deleteDependent(dependent);
	}
	
	@DeleteMapping(value = "/dependent/admin/deleteAll")
	public void deleteAllDependents() {
		dependentService.deleteAllDependents();
	}
}
