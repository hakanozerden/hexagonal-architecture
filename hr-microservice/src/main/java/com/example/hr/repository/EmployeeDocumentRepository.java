package com.example.hr.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.hr.document.EmployeeDocument;

/**
 * @author hakan.ozerden
 */
public interface EmployeeDocumentRepository extends MongoRepository<EmployeeDocument, String> {
	List<EmployeeDocument> findAllByBirthYearBetween(int fromYear, int toYear);

	List<EmployeeDocument> findAllByDepartment(String department);
}
