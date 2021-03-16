package com.example.hr.infrastructure;

import com.example.hr.events.EmployeeEvent;

/**
 * @author hakan.ozerden
 */
public interface EventPublisher {
	void publish(EmployeeEvent event);
}