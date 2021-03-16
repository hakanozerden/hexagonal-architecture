package com.example.hr.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hakan.ozerden
 */
@Data
@AllArgsConstructor
public class RestErrorMessage {
	private String message;
}
