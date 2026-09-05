package com.example.kanban;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
	
	List<Application> findByRole(String role);
	
	
	List<Application> findByDate(boolean ascending);
	List<Application> findByDeadline(boolean ascending);

}
