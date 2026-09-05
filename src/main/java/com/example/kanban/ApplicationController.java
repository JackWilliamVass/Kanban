package com.example.kanban;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApplicationController {
	
	private final ApplicationService service;
	
	public ApplicationController(ApplicationService service) {
		this.service = service;
	}
	
	// GET /api/home
	@GetMapping("/home")
	public List<Application> getAllApplications() {
		return service.getAllApplications();
	}
	
	// POST /api/home
	@GetMapping("/home")
	public ResponseEntity<Application> addApplication(Application application) {
		Application newApplication = service.addApplication(application);
		return ResponseEntity.status(HttpStatus.CREATED).body(newApplication);
	}
	
	// DELETE
	public ResponseEntity<Application> deleteById(@RequestParam(value="id") Long id) {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	// I don't think this'll work?
	// I know why RequestBody is required in theory, but why do sources vary on it so much.... =-=
	// PATCH
	@PutMapping("/home")
	public ResponseEntity<Application> updateApplication(@RequestBody Application application) {
		Application updatedApplication = service.updateApplication(application);
		return ResponseEntity.status(HttpStatus.CREATED).body(updatedApplication);
	}
}
