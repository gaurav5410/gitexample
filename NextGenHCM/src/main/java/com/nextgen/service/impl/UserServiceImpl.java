/* 
 * ===========================================================================
 * File Name UserServiceImpl.java
 * 
 * Created on Jul 22, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of ArtigemRS-FI. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of ArtigemRS-FI.
 *
 * Copyright (C) ArtigemRS-FI. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: UserServiceImpl.java,v $
 * ===========================================================================
 */

package com.nextgen.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nextgen.dao.IBaseDAO;
import com.nextgen.dto.BaseAppDTO;
import com.nextgen.dto.CreateEmployeeDTO;
import com.nextgen.enums.BaseAppConstants;
import com.nextgen.exception.ApplicationCustomException;
import com.nextgen.model.Employee;
import com.nextgen.service.UserService;
import com.nextgen.utils.Utility;

/**
 * Class have all the implementations for the user service methods which are
 * related to customer basic functionality.
 * 
 * @author gauravk - Chetu
 * @version 1.0 - July 22, 2016
 */

@Service
public class UserServiceImpl implements UserService {

	
	
	 @Autowired
	 private IBaseDAO<Employee> employeeBaseDAO;
	@Autowired
	private MessageSource source;
	 
	 /**This method is used to create a worker into the system.
	 * 
	 * @param createWorkerDTO						worker related information to create the worker
	 * @return createEmployeeDTO						worker information after creating the worker into the system.
	 */
	@Override
	@Transactional
	public CreateEmployeeDTO createEmployee(CreateEmployeeDTO createEmployeeDTO) throws ApplicationCustomException {

		if (createEmployeeDTO != null) {
			final Employee existingUser = employeeBaseDAO.findUniqueByColumn(Employee.class, "email",
					createEmployeeDTO.getEmail());
			if (existingUser != null) {
				throw new ApplicationCustomException(source.getMessage("user.email.exists.message", null, null));
			}
		}
		final Employee contact = getContactFromWorkerDTO(createEmployeeDTO, null);
		if (contact != null) {
			contact.setNationalId(Utility.getRandomHexString());
			employeeBaseDAO.save(contact);
			createEmployeeDTO.setId(contact.getId());
			createEmployeeDTO.setNationalId(contact.getNationalId());
			createEmployeeDTO.setHireDate(contact.getHiredate().toString());
			return createEmployeeDTO;
		} else {
			return null;
		}
	}
	
	 /**This method is used to update a worker into the system.
	 * 
	 * @param createWorkerDTO							worker related information to create the worker
	 * @return createEmployeeDTO						worker information after creating the worker into the system.
	 */
	@Override
	@Transactional
	public CreateEmployeeDTO updateEmployee(final CreateEmployeeDTO createEmployeeDTO)
			throws ApplicationCustomException {
		if (createEmployeeDTO != null) {
			if (createEmployeeDTO.getNationalId() != null && !createEmployeeDTO.getNationalId().equals("")) {

				final Employee existingUser = employeeBaseDAO.findUniqueByColumn(Employee.class, "nationalId",
						createEmployeeDTO.getNationalId());
				if (existingUser != null) {
					final Employee contact = getContactFromWorkerDTO(createEmployeeDTO, existingUser);
					if (contact != null) {
						employeeBaseDAO.saveOrUpdate(contact);
						createEmployeeDTO.setId(contact.getId());
						createEmployeeDTO.setNationalId(contact.getNationalId());
						createEmployeeDTO.setHireDate(contact.getHiredate().toString());
						return createEmployeeDTO;
					} else {
						return null;
					}
				}

			} else {
				throw new ApplicationCustomException(
						source.getMessage("employee.national.id.require.message", null, null));
			}
		} else {
			throw new ApplicationCustomException(source.getMessage("employee.not.exists.message", null, null));
		}
		return createEmployeeDTO;
	}
	
	
	/**This method is used to get the contact model object from worker DTO.
	 * @param createEmployeeDTO
	 * @return contact										contact model object
	 * @throws ApplicationCustomException 
	 * @throws NoSuchMessageException 
	 */
	private Employee getContactFromWorkerDTO(final CreateEmployeeDTO createEmployeeDTO, Employee employee)
			throws NoSuchMessageException, ApplicationCustomException {
		if (createEmployeeDTO != null) {
			if (employee == null) {
				employee = new Employee();
			}
			employee.setAuthorities(BaseAppConstants.USER.getValue());
			employee.setAddressLineOne(createEmployeeDTO.getAddressLineOne());
			employee.setAddressLineTwo(createEmployeeDTO.getAddressLineTwo());
			employee.setDob(Utility.parseDate(createEmployeeDTO.getDob()));
			employee.setEmail(createEmployeeDTO.getEmail());
			employee.setGender(createEmployeeDTO.getGender());
			employee.setHiredate(new Date());
			employee.setFirstname(createEmployeeDTO.getFirstName());
			employee.setLastname(createEmployeeDTO.getLastName());
			employee.setMiddlename(createEmployeeDTO.getMiddleName());
			employee.setPhone(createEmployeeDTO.getPhone());
			employee.setZip(createEmployeeDTO.getZip());
			final BaseAppDTO city = createEmployeeDTO.getCity();
			if (city != null) {
				employee.setCity(city.getName());
			}
			final BaseAppDTO state = createEmployeeDTO.getCity();
			if (state != null) {
				employee.setState(state.getName());
			}
			final BaseAppDTO country = createEmployeeDTO.getCity();
			if (country != null) {
				employee.setCountry(country.getName());
			}
			return employee;
		} else {
			return null;
		}
	}

}
