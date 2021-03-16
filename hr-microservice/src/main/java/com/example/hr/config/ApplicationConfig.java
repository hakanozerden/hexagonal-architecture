package com.example.hr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hr.application.HrApplication;
import com.example.hr.application.impl.HrApplicationImpl;
import com.example.hr.infrastructure.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

/**
 * @author hakan.ozerden
 */
@Configuration
public class ApplicationConfig {

	@Bean
	public HrApplication hrApplication(EmployeeRepository employeeRepository, EventPublisher eventPublisher) {
		return new HrApplicationImpl(employeeRepository, eventPublisher);
	}
}