package com.example.kanban;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.kanban.dto.UpdateApplicationDto;

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
	public Application updateApplication(UpdateApplicationDto application, Long id) {
		Optional<Application> tempApplication = repository.findById(id);
		Application newApplication = tempApplication.isPresent() ? tempApplication.get() : new Application();
		if (application.deadline != null) newApplication.setDeadline(application.deadline);
		if (application.notes != null) newApplication.setNotes(application.notes);
		if (application.status != null) newApplication.setStatus(application.status);
		return newApplication;
	}
}
