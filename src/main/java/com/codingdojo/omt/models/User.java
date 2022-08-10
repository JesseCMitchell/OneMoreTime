package com.codingdojo.omt.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "users")
public class User {
	// ========== Primary Key ===================	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	   
		// ========== Member Variables ==============
		@NotEmpty(message="Field Required")
	    @Size(min=3, max=30, message="Field must be between 3 and 30 characters")
	    private String first_name;
		
		@NotEmpty(message="Field Required")
	    @Size(min=3, max=30, message="Field must be between 3 and 30 characters")
	    private String last_name;

		@NotEmpty(message="Field Required")
	    @Size(min=3, max=30, message="Username must be between 3 and 30 characters")
	    private String user_name;
		
	    @NotEmpty(message="Field Required")
	    @Email(message="Please enter a valid email")
	    private String email;
	    
	    @NotEmpty(message="Field Required")
	    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
	    private String password;
	    
	    @Transient
	    @NotEmpty(message="Field Required")
	    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
	    private String confirm;
	    
	 // ========== Data Creation Trackers ========
	    @Column(updatable=false) // This will not allow the createdAt column to be updated after creation
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	 // ========== Data Creation Event ===========
	 	@PrePersist
	     protected void onCreate(){
	         this.createdAt = new Date();
	     }
	     @PreUpdate
	     protected void onUpdate(){
	         this.updatedAt = new Date();
	     
	     }
     // =========== Relationships ================		     
	     @Column(updatable=false)
	     @OneToMany(mappedBy="id", fetch = FetchType.LAZY)
	     private List<Program> programs;
	     
	  // ========== Constructors ===================
	    
	    public User() {}
	    
	 // =========== Getters / Setters ==============
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirst_name() {
			return first_name;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		public String getUser_name() {
			return user_name;
		}
		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getConfirm() {
			return confirm;
		}
		public void setConfirm(String confirm) {
			this.confirm = confirm;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
	    
	 
	    
	    
	    
}
