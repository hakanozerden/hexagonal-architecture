package com.example.hr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hakan.ozerden
 */
@Data
@AllArgsConstructor
public class EmployeeKafkaEvent {

	private String identity;

}