package com.example.hr.service.impl;

import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.Currency;
import com.example.hr.domain.Employee;
import com.example.hr.domain.Identity;
import com.example.hr.request.HireEmployeeRequest;
import com.example.hr.response.FireEmployeeResponse;
import com.example.hr.response.HireEmployeeResponse;
import com.example.hr.service.HrService;

/**
 * @author hakan.ozerden
 */
public class HrServiceImpl implements HrService {

	@Autowired
	private HrApplication hrApplication;

	@Override
	@Transactional
	public HireEmployeeResponse hireEmployee(HireEmployeeRequest request) {
		var kimlikNo = Identity.valueOf(request.getIdentity());
		var photo = request.getPhoto();
		byte[] data = null;
		if (Objects.nonNull(photo))
			data = photo.getBytes();

		Employee employee = new Employee.Builder(kimlikNo).fullname(request.getFirstName(), request.getLastName())
				.iban(request.getIban()).salary(request.getSalary(), Currency.TRY)
				.department(request.getDepartment().name()).jobType(request.getType().name()).photo(data)
				.birthYear(request.getBirthYear()).build();
		hrApplication.hireEmployee(employee);
		return new HireEmployeeResponse("success");
	}

	@Override
	@Transactional
	public FireEmployeeResponse fireEmployee(String identity) {
		var employee = hrApplication.fireEmployee(Identity.valueOf(identity));
		if (employee.isEmpty())
			return new FireEmployeeResponse("failed", "Cannot find employee to fire.");
		return new FireEmployeeResponse("success");
	}
}
