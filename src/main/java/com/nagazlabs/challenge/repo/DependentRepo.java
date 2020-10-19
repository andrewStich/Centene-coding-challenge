package com.nagazlabs.challenge.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagazlabs.challenge.models.Dependent;

@Repository
public interface DependentRepo extends CrudRepository<Dependent, Integer> {

	@Query(value = "select * from dependents where enrollee_id = ?", nativeQuery = true)
	public List<Dependent> getByEnrollee(int id);
	
	@Query(value = "delete from dependents where enrollee_id = ?", nativeQuery = true)
	public void deleteByEnrollee(int id);
}
