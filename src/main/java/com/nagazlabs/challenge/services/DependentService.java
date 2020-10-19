package com.nagazlabs.challenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagazlabs.challenge.models.Dependent;
import com.nagazlabs.challenge.repo.DependentRepo;

@Service
public class DependentService {

	@Autowired
	private DependentRepo dependentRepo;
	
	public Dependent addDependent(Dependent dependent) {
		if (dependent.getFirstName() != null && dependent.getLastName() != null && dependent.getBirthDate() != null) {
			if(dependentRepo.existsById(dependent.getId())) {
				return dependent;
			}
			else {
				return dependentRepo.save(dependent);
			}
		}
		
		return null;
	}
	
	public List<Dependent> getEnrolleeDependents(int id) {
		return dependentRepo.getByEnrollee(id);
	}
	
	public List<Dependent> getAllDependents() {
		return (List<Dependent>) dependentRepo.findAll();
	}
	
	public Dependent getDependentById(int id) {
		Optional<Dependent> dependent = dependentRepo.findById(id);
		
		if (dependent.isPresent()) {
			return dependent.get();
		}
		
		return null;
	}
	
	public boolean updateDependent(Dependent dependent) {
		if (dependent.getFirstName() != null && dependent.getLastName() != null && dependent.getBirthDate() != null && dependentRepo.existsById(dependent.getId())) {
			return dependentRepo.save(dependent) != null;
		}
		
		return false;
	}
	
	public boolean deleteDependent(Dependent dependent) {
		if (dependentRepo.existsById(dependent.getId())) {
			dependentRepo.delete(dependent);
			return true;
		}
		
		return false;
	}
	
	public void deleteAllDependents() {
		dependentRepo.deleteAll();
	}
}
