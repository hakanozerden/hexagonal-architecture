package com.example.hr.adapter;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import com.example.hr.document.EmployeeDocument;
import com.example.hr.domain.Employee;
import com.example.hr.domain.Identity;
import com.example.hr.repository.EmployeeDocumentRepository;
import com.example.hr.repository.EmployeeRepository;

/**
 * @author hakan.ozerden
 */
@Repository
@ConditionalOnProperty(name = "database", havingValue = "mongo")
public class MongoRepositoryEmployeeAdapter implements EmployeeRepository {

	@Autowired
	private EmployeeDocumentRepository employeeDocumentRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public boolean existsByIdentity(Identity identity) {
		return employeeDocumentRepository.existsById(identity.getValue());
	}

	@Override
	public Employee persist(Employee employee) {
		// Employee --> EmployeeDocument
		var employeeDocument = mapper.map(employee, EmployeeDocument.class);
		var emp = employeeDocumentRepository.save(employeeDocument);
		// EmployeeDocument --> Employee
		return mapper.map(emp, Employee.class);
	}

	@Override
	public Optional<Employee> removeByIdentity(Identity identity) {
		var employeeDocument = employeeDocumentRepository.findById(identity.getValue());
		if (employeeDocument.isEmpty())
			return Optional.empty();
		EmployeeDocument empDoc = employeeDocument.get();
		employeeDocumentRepository.delete(empDoc);
		// EmployeeDocument --> Employee
		var employee = mapper.map(empDoc, Employee.class);
		return Optional.of(employee);
	}

}
