/* 
 * ===========================================================================
 * File Name WorkerController.java
 * 
 * Created on Aug 4, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of ArtigemRS-FI. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of ArtigemRS-FI.
 *
 * Copyright (C) ArtigemRS-FI. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: WorkerController.java,v $
 * ===========================================================================
 */
package com.nextgen.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nextgen.dto.CreateEmployeeDTO;
import com.nextgen.enums.SecurityError;
import com.nextgen.exception.ApplicationCustomException;
import com.nextgen.response.BaseResponse;
import com.nextgen.service.UserService;

/**
 * This Controller class created for to handle worker related tasks.
 * 
 * @author gauravk
 * @version 1.0 - Feb 27, 2017
 */

@RestController
@RequestMapping("/api")
public class EmployeeController {
	private static final Logger LOGGER = Logger.getLogger(EmployeeController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private MessageSource source;

	/**
	 * This controller method is created to authenticate the mobile application
	 * user
	 * 
	 * @date Aug 22, 2016
	 * @param authenticationRequest
	 *            request parameter to carry the required information to
	 *            authenticate the user
	 * @return ResponseEntity response to handle the response and the status
	 *         message
	 * @throws ApplicationCustomException
	 *             exception in case of any miss leading to the user information
	 */
	@RequestMapping(value = "/create/employee", method = RequestMethod.POST)
	public ResponseEntity<?> createEmployee(@RequestBody CreateEmployeeDTO createWorkerDTO) {
		/* Perform the authentication */
		LOGGER.info("Inside the Worker Controller...");
		try {
			final CreateEmployeeDTO createdWorkerDetails = userService.createEmployee(createWorkerDTO);
			if (createdWorkerDetails != null) {
				return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
						source.getMessage("employee.create.success.details.message",null,null), createdWorkerDetails),
						HttpStatus.OK);
			}
		} catch (ApplicationCustomException e) {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
					SecurityError.INVALID_DATA.getCode(), e.getMessage()), HttpStatus.OK);
		}

		return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(), SecurityError.INVALID_LOGIN.getCode(),
				SecurityError.INVALID_LOGIN.getDescription()), HttpStatus.OK);
	}
	
	/**
	 * This controller method is created to authenticate the mobile application
	 * user
	 * 
	 * @date Aug 22, 2016
	 * @param authenticationRequest
	 *            request parameter to carry the required information to
	 *            authenticate the user
	 * @return ResponseEntity response to handle the response and the status
	 *         message
	 * @throws ApplicationCustomException
	 *             exception in case of any miss leading to the user information
	 */
	@RequestMapping(value = "/update/employee", method = RequestMethod.POST)
	public ResponseEntity<?> updateEmployee(@RequestBody CreateEmployeeDTO createWorkerDTO) {
		/* Perform the authentication */
		LOGGER.info("Inside the Worker Controller...");
		try {
			final CreateEmployeeDTO createdWorkerDetails = userService.updateEmployee(createWorkerDTO);
			if (createdWorkerDetails != null) {
				return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
						source.getMessage("employee.create.success.details.message",null,null), createdWorkerDetails),
						HttpStatus.OK);
			}
		} catch (ApplicationCustomException e) {
			return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(),
					SecurityError.INVALID_DATA.getCode(), e.getMessage()), HttpStatus.OK);
		}

		return new ResponseEntity<Object>(new BaseResponse(HttpStatus.OK.value(), SecurityError.INVALID_LOGIN.getCode(),
				SecurityError.INVALID_LOGIN.getDescription()), HttpStatus.OK);
	}

}