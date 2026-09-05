package com.example.kanban;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// It is assumed this entity maps directly to a table called 'Application' in a db
@Entity
public class Application {
	//company, role, status, deadlines, notes, dates applied
	// May need to add a generated ID later for multi-person use later*
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String company;
	private String role;
	private String status;
	private String deadline;
	private String notes;
	private String dateApplied;
	
	//required for JPA, this is protected as it's never used directly
	protected Application() {}
	
	public Application(String company, String role, String status, String deadline, String notes, String datesApplied) {
		this.company = company;
		this.role = role;
		this.status = status;
		this.deadline = deadline;
		this.notes = notes;
		this.dateApplied = datesApplied;
	}
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public String getCompany() { return company; }
	public void setCompany(String company) { this.company = company; }
	
	public String getRole() { return role; }
	public void setRole(String role) { this.role = role; }
	
	public String getStatus() { return status; }
	public void setStatus(String status) { this.status = status; }
	
	public String getDeadlines() { return deadline; }
	public void setDeadline(String deadline) { this.deadline = deadline; }
	
	public String getNotes() { return notes; }
	public void setNotes(String notes) { this.notes = notes; }
	
	public String getDate() { return dateApplied; }
	public void setDate(String dateApplied) { this.dateApplied = dateApplied; }
}
