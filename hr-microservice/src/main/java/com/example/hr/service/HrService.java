package com.example.hr.service;

import com.example.hr.request.HireEmployeeRequest;
import com.example.hr.response.FireEmployeeResponse;
import com.example.hr.response.HireEmployeeResponse;

/**
 * @author hakan.ozerden
 */
public interface HrService {
	HireEmployeeResponse hireEmployee(HireEmployeeRequest request);

	FireEmployeeResponse fireEmployee(String identity);
}
