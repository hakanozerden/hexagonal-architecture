package com.example.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hr.document.EmployeeDocument;
import com.example.hr.entity.EmployeeEntity;

/**
 * @author hakan.ozerden
 */
public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, String> {

	List<EmployeeDocument> findAllByBirthYearBetween(int fromYear, int toYear);

	List<EmployeeDocument> findAllByDepartment(String department);
}