package com.codingdojo.omt.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.codingdojo.omt.models.Program;
import com.codingdojo.omt.repositories.ProgramRepo;

@Service
public class ProgramService {
	// adding the book repository as a dependency
	private final ProgramRepo programRepo;
	
	// Using dependency injection to make this available
	public ProgramService(ProgramRepo programRepo) {
		this.programRepo = programRepo;
	}
	
	// method returns all the programs
	public List<Program> allPrograms() {
		return programRepo.findAll();
	}
	
	// method creates a program
	public Program addProgram(Program program) {
		return programRepo.save(program);
	}
	

	
	// finds One program by Id	
	public Program findProgram(Long id) {
		Optional<Program> optionalProgram = programRepo.findById(id);
		if(optionalProgram.isPresent()) {
			return optionalProgram.get();
		}else {
			return null;
		}
	}
	
	// Method updates the program - looks the same as create (both use .save)
	public Program updateProgram(Program program) {
		return programRepo.save(program);
	}
	
	// Method deletes the program
	public void deleteProgram(Long id) {
		Optional<Program> optionalProgram = programRepo.findById(id);
		if(optionalProgram.isPresent()) {
			programRepo.deleteById(id);
		}
	}


	
}
