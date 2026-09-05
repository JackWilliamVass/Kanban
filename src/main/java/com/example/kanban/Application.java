package com.example.kanban;

import jakarta.persistence.Entity;

// It is assumed this entity maps directly to a table called 'Application' in a db
@Entity
public class Application {
	//company, role, status, deadlines, notes, dates applied
	// May need to add a generated ID later for multi-person use later*
	
	private String company;
	private String role;
	private String status;
	private String deadlines;
	private String notes;
	private String dateApplied;
	
	//required for JPA, this is protected as it's never used directly
	protected Application() {}
	
	public Application(String company, String role, String status, String deadlines, String notes, String datesApplied) {
		this.company = company;
		this.role = role;
		this.status = status;
		this.deadlines = deadlines;
		this.notes = notes;
		this.dateApplied = datesApplied;
	}
	
	public String getCompany() {
		return company;
	}
	
	public String getRole() {
		return role;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getDeadlines() {
		return deadlines;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public String getDates() {
		return dateApplied;
	}
}
