package com.example.hr.application.impl;

import java.util.Optional;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.Employee;
import com.example.hr.domain.Identity;
import com.example.hr.events.EmployeeFiredEvent;
import com.example.hr.events.EmployeeHiredEvent;
import com.example.hr.infrastructure.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

/**
 * @author hakan.ozerden
 */
public class HrApplicationImpl implements HrApplication {

	private EmployeeRepository employeeRepository;
	private EventPublisher eventPublisher;

	public HrApplicationImpl(EmployeeRepository employeeRepository, EventPublisher eventPublisher) {
		this.employeeRepository = employeeRepository;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public Employee hireEmployee(Employee employee) {
		var identity = employee.getidentity();
		if (employeeRepository.existsByIdentity(identity)) {
			throw new IllegalArgumentException("Employee already exists.");
		}
		Employee emp = employeeRepository.persist(employee);
		eventPublisher.publish(new EmployeeHiredEvent(identity));
		return emp;
	}

	@Override
	public Optional<Employee> fireEmployee(Identity identity) {
		Optional<Employee> employee = employeeRepository.removeByIdentity(identity);
		if (employee.isPresent()) {
			eventPublisher.publish(new EmployeeFiredEvent(identity));
		}
		return employee;
	}

}
