package com.codingdojo.omt.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.omt.models.LoginUser;
import com.codingdojo.omt.models.User;
import com.codingdojo.omt.repositories.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	// ============ Registration and Login =============

		public User register(User newUser, BindingResult result) {
		       
	    	Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
	    	
	    	// Reject if email is taken (present in database)
	    	if(potentialUser.isPresent()) {
	    		result.rejectValue("email", "Matches", "An account with that email already exists!");
	    	}
	    	
	        // Reject if password doesn't match confirmation
	    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
	    		result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
	    	}
	    	
	    	// Return null if result has errors
	    	if(result.hasErrors()) {
	    		return null;
	    	}
	    
	        // Hash and set password, save user to database
	    	String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
	    	newUser.setPassword(hashed);
	    	return userRepo.save(newUser);
	    	
	    }
		
		
		
		
		public User login(LoginUser newLogin, BindingResult result) {
	    	
	    	Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
	        
	    	// Find user in the DB by email
	        // Reject if NOT present
	    	if(!potentialUser.isPresent()) {
	    		result.rejectValue("email", "Matches", "User not found!");
	    		return null;
	    	}
	    	
	    	// User exists, retrieve user from DB
	    	User user = potentialUser.get();
	        
	        // Reject if BCrypt password match fails
	    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
	    	    result.rejectValue("password", "Matches", "Invalid Password!");
	    	}
	    	
	    	// Return null if result has errors
	    	if(result.hasErrors()) {
	    		return null;
	    	}
	    	
	        // Otherwise, return the user object
	        return user;
	    }

	// ============ Create / Update ====================



	// ============ Read ===============================

	    public User findById(Long id) {
	    	return userRepo.findById(id).orElse(null);
	    }

	// ============ Delete =============================
}
