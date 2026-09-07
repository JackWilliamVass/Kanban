package com.example.kanban.dto;

import com.example.kanban.Application;

public class ApplicationMapper {
	
	
	public ApplicationDto toDto(Application application) {
		
		// No point right now as they're just seeing the whole entity anyways (will become useful later??)
		
		ApplicationDto dto = new ApplicationDto();
		
		dto.id = application.getId();
		dto.company = application.getCompany();
		dto.dateApplied = application.getDate();
		dto.deadline = application.getDeadlines();
		dto.role = application.getRole();
		dto.notes = application.getNotes();
		dto.status = application.getStatus();
		
		return dto;
	}
	
	public static Application toEntity(CreateApplicationDto dto) {
		return new Application(dto.company, dto.role, dto.status, dto.deadline, dto.notes, dto.dateApplied);
	}
	
	public static void updateEntity(UpdateApplicationDto dto, Application application) {
		
		if (dto.deadline != null) application.setDeadline(dto.deadline);
		if (dto.notes != null) application.setNotes(dto.notes);
		if (dto.status != null) application.setStatus(dto.status);
	}
}
