package com.example.hr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.example.hr.domain.Currency;
import com.example.hr.domain.Department;
import com.example.hr.domain.JobType;

import lombok.Builder;
import lombok.Data;

/**
 * @author hakan.ozerden
 */
@Entity
@Table(name = "employee")
@Builder
@Data
public class EmployeeEntity {

	@Id
	@Column(name = "identity")
	private String identity;

	private String fullName;

	private double salary;

	@Enumerated(EnumType.STRING)
	private Currency currency;

	private String iban;

	private int birthYear;

	@Enumerated(EnumType.STRING)
	private Department department;

	@Enumerated(EnumType.STRING)
	private JobType jobType;

	@Lob
	@Column(columnDefinition = "longblob")
	private byte[] photo;
}
