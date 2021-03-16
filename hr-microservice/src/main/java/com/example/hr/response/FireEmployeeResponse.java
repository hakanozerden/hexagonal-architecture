package com.example.hr.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author hakan.ozerden
 */
@JsonInclude(Include.NON_NULL)
@AllArgsConstructor
@Getter
public class FireEmployeeResponse {

	private String status;
	private String reason;

	public FireEmployeeResponse(String status) {
		this.status = status;
	}

}
