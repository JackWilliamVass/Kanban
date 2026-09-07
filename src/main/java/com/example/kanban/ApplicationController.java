package com.example.kanban;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kanban.dto.UpdateApplicationDto;

@RestController
@RequestMapping("/api")
public class ApplicationController {
	
	private final ApplicationService service;
	
	public ApplicationController(ApplicationService service) {
		this.service = service;
	}
	
	// GET /api/home
	@GetMapping("/getApplications")
	public List<Application> getAllApplications() {
		return service.getAllApplications();
	}
	
	// POST /api/home
	@PostMapping("/addApplication")
	public ResponseEntity<Application> addApplication(Application application) {
		Application newApplication = service.addApplication(application);
		return ResponseEntity.status(HttpStatus.CREATED).body(newApplication);
	}
	
	// DELETE
	@DeleteMapping("/deleteApplication")
	public ResponseEntity<Application> deleteById(@RequestParam(value="id") Long id) {
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatusCode.valueOf(200));
	}
	
	// I need to implement DTOs for validation etc
	// PATCH
	@PatchMapping("/updateApplication")
	public ResponseEntity<Application> updateApplication(@RequestBody UpdateApplicationDto application,
			@RequestParam(value="id") Long id) {
	}
}
