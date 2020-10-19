package com.nagazlabs.challenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagazlabs.challenge.models.Enrollee;
import com.nagazlabs.challenge.models.Dependent;
import com.nagazlabs.challenge.repo.EnrolleeRepo;

@Service
public class EnrolleeService {

	@Autowired
	private EnrolleeRepo enrolleeRepo;

	@Autowired
	private DependentService dependentService;

	public Enrollee addEnrollee(Enrollee enrollee) {
		if (enrollee.getFirstName() != null && enrollee.getLastName() != null && enrollee.getBirthDate() != null)
			return enrolleeRepo.save(enrollee);

		return null;
	}
	
	public Enrollee getEnrolleeById(int id) {
		Optional<Enrollee> enrollee = enrolleeRepo.findById(id);
		
		if (enrollee.isPresent()) {
			return enrollee.get();
		}
		
		return null;
	}

	public List<Enrollee> getAllEnrollees() {
		return (List<Enrollee>) enrolleeRepo.findAll();
	}

	public Enrollee updateEnrollee(Enrollee enrollee) {
		if (enrollee.getFirstName() != null && enrollee.getLastName() != null && enrollee.getBirthDate() != null
				&& enrolleeRepo.existsById(enrollee.getId()))
			return enrolleeRepo.save(enrollee);

		return null;
	}

	public boolean deleteEnrollee(Enrollee enrollee) {
		if (enrolleeRepo.existsById(enrollee.getId())) {
			for (Dependent d : enrollee.getDependents()) {
				dependentService.deleteDependent(d);
			}
			
			enrolleeRepo.delete(enrollee);
			return true;
		}

		return false;
	}

	public boolean addDependent(Enrollee enrollee, Dependent dependent) {
		if (dependent.getEnrolleeId() == enrollee.getId()) {
			enrollee.addDependent(dependent);
			dependentService.addDependent(dependent);
			return true;
		}
			
		return false;
	}

	public boolean deleteDependent(Enrollee enrollee, Dependent dependent) {
		enrollee.deleteDependent(dependent);
		dependentService.deleteDependent(dependent);

		return updateEnrollee(enrollee) != null;
	}

	public void deleteAllEnrollees() {
		enrolleeRepo.deleteAll();
	}
}
