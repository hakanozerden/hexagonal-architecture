package com.example.hr.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.hr.domain.Currency;
import com.example.hr.domain.Department;
import com.example.hr.domain.JobType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author hakan.ozerden
 */
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Document(collection = "employees")
public class EmployeeDocument {
	@Id
	private String identity;

	private String fullname;

	private double salary;

	private Currency currency;

	private String iban;

	private int birthYear;

	private Department department;

	private JobType jobType;

	private String photo;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identity == null) ? 0 : identity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDocument other = (EmployeeDocument) obj;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeDocument [identity=" + identity + ", fullname=" + fullname + ", salary=" + salary
				+ ", currency=" + currency + ", iban=" + iban + ", birthYear=" + birthYear + ", department="
				+ department + ", jobType=" + jobType + "]";
	}

}