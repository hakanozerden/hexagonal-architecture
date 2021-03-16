package com.example.hr.events;

import com.example.hr.domain.Identity;

/**
 * @author hakan.ozerden
 */
public class EmployeeFiredEvent extends EmployeeEvent {

	public EmployeeFiredEvent(Identity identity) {
		super(identity);
	}

}