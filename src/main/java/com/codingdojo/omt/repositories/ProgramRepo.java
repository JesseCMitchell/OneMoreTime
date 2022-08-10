package com.codingdojo.omt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.omt.models.Program;


@Repository
public interface ProgramRepo extends CrudRepository<Program, Long> {

	List<Program> findAll();
	List<Program> findByUserIdIs(Long userId);
	List<Program> findByDescriptionContaining(String search);

	
}
