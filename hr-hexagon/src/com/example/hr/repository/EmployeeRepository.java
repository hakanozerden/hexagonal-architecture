package com.example.hr.repository;

import java.util.Optional;

import com.example.hr.domain.Employee;
import com.example.hr.domain.Identity;

/**
 * @author hakan.ozerden
 */
public interface EmployeeRepository {

	boolean existsByIdentity(Identity identity);

	Employee persist(Employee employee);

	Optional<Employee> removeByIdentity(Identity identity);
}
