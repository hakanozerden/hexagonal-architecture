package com.example.hr.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import com.example.hr.domain.Department;
import com.example.hr.domain.JobType;
import com.example.hr.validation.Iban;
import com.example.hr.validation.TcKimlikNo;

import lombok.Data;

/**
 * @author hakan.ozerden
 */
@Data
public class HireEmployeeRequest {

	@TcKimlikNo
	private String identity;

	@Pattern(regexp = "^[A-Z][a-z]+$")
	private String firstName;

	@Pattern(regexp = "^[A-Z][a-z]+$")
	private String lastName;

	@Iban
	private String iban;

	private double salary;

	private Department department;

	private JobType type;

	@Min(1950)
	private int birthYear;

	private String photo;
}
