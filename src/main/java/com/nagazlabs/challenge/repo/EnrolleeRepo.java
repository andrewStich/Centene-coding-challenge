package com.nagazlabs.challenge.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagazlabs.challenge.models.Enrollee;

@Repository
public interface EnrolleeRepo extends CrudRepository<Enrollee, Integer> {

}
