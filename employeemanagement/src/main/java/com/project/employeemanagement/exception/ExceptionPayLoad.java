package com.project.employeemanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionPayLoad {
	private int errorCode;
	private String errorMsg;
}
