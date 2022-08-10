package com.codingdojo.omt.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name= "programs")
public class Program {
	// ========== Primary Key ===================
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// ========== Member Variables ==============
	@NotBlank(message="Field Required")
	@Size(min=3, message="Name must be at least 3 characters long")
	private String name;
	
	@NotNull(message="Field Required")
    @Min(value=5, message="Zip code must be 5 digits")
    private int zip;
	
	@NotBlank(message="Field Required")
	@Size(min=10, message="Phone must be 10 digits")
	private String phone;
	
	@NotEmpty(message="Field Required")
    @Email(message="Please enter a valid email")
    private String email;
	
	@NotBlank(message="Field Required")
	@Size(min=3, message="Description must be at least 3 characters long")
	private String description;
	
	private String url;
	
	@Column(length=45, nullable=true)
	private String photo;
	
	// ========== Data Creation Event ===========
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    
    }
    
 // ========== Data Creation Trackers ========
    @Column(updatable=false) // This will not allow the createdAt column to be updated after creation
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // ============ Relationships ======================
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
    
    // ============ Constructors =======================
    public Program() {}
    
    public Program(String name, int zip, String phone, String email, String description, String url, String photo, User user) {
    	this.name = name;
    	this.zip = zip;
    	this.phone = phone;
    	this.email = email;
    	this.description = description;
    	this.url = url;
    	this.photo = photo;
    	this.user = user;
    }
    
 // =========== Getters / Setters ===============
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
    
}
