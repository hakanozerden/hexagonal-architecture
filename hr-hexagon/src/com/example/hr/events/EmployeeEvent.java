package com.example.hr.events;

import com.example.hr.domain.Identity;

/**
 * @author hakan.ozerden
 */
public abstract class EmployeeEvent {
	private Identity identity;

	public EmployeeEvent(Identity identity) {
		this.identity = identity;
	}

	public Identity getIdentity() {
		return identity;
	}

}