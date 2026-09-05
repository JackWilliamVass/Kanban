package com.example.kanban;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

// I'm not sure what @Transactional does apart from it being a security thing
// Should probably look that up later =-=
@Service
@Transactional
public class ApplicationService {
	private final ApplicationRepository repository;
	
	public ApplicationService(ApplicationRepository repository) {
		this.repository = repository;
	}
	
	// GET
	public List<Application> getAllApplications() {
		return repository.findAll();
	}
	
	// DELETE
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	// POST
	public Application addApplication(Application application) {
		return repository.save(application);
	}
	
	// PATCH
	// Logic is the same as add so the logic MUST go in the controller! yippeee
	public Application updateApplication(Application application) {
		return repository.save(application);
	}
}
