package com.example.hr.events;

import com.example.hr.domain.Identity;

/**
 * @author hakan.ozerden
 */
public class EmployeeHiredEvent extends EmployeeEvent {

	public EmployeeHiredEvent(Identity identity) {
		super(identity);
	}

}