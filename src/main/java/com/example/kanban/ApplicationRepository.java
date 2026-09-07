package com.example.kanban;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kanban.dto.UpdateApplicationDto;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
