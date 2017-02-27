/* 
 * ===========================================================================
 * File Name AgentDTO.java
 * 
 * Created on Jul 14, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of ArtigemRS-FI. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of ArtigemRS-FI.
 *
 * Copyright (C) ArtigemRS-FI. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: AgentDTO.java,v $
 * ===========================================================================
 */

package com.nextgen.dto;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

/**
 * This class contains the details of agent
 * 
 * @author gauravk - Chetu
 * @version 1.0 - Jul 14, 2016
 */

@Transactional
public class AgentDTO implements Serializable {

	/** long Short Description */
	private static final long serialVersionUID = -6243566076209342778L;
	private Long agentId;
	private String firstName;
	private String lastName;
	private String userEmail;
	private String agentEmail;
	private Integer companyId;
	private String cellPhone;
	private String eveningTimePhone;
	private String dayTimePhone;
	private String token;

	public AgentDTO(Long agentId, String firstName, String lastName, String userEmail, String agentEmail,
			Integer companyId, String cellPhone, String eveningTimePhone, String dayTimePhone, String token) {
		super();
		this.agentId = agentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.agentEmail = agentEmail;
		this.companyId = companyId;
		this.cellPhone = cellPhone;
		this.eveningTimePhone = eveningTimePhone;
		this.dayTimePhone = dayTimePhone;
		this.token = token;
	}

	public AgentDTO() {
		super();
	}

	/**
	 * @return agentId of Long Type
	 */
	public Long getAgentId() {
		return agentId;
	}

	/**
	 * @param Long
	 *            type set into agentId
	 */
	public void setAgentId(Long agentId) {
		this.agentId = agentId;
	}

	/**
	 * @return firstName of String Type
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param String
	 *            type set into firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return lastName of String Type
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param String
	 *            type set into lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return userEmail of String Type
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param String
	 *            type set into userEmail
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return agentEmail of String Type
	 */
	public String getAgentEmail() {
		return agentEmail;
	}

	/**
	 * @param String
	 *            type set into agentEmail
	 */
	public void setAgentEmail(String agentEmail) {
		this.agentEmail = agentEmail;
	}

	/**
	 * @return companyId of Integer Type
	 */
	public Integer getCompanyId() {
		return companyId;
	}

	/**
	 * @param Integer
	 *            type set into companyId
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return cellPhone of String Type
	 */
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * @param String
	 *            type set into cellPhone
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	/**
	 * @return eveningTimePhone of String Type
	 */
	public String getEveningTimePhone() {
		return eveningTimePhone;
	}

	/**
	 * @param String
	 *            type set into eveningTimePhone
	 */
	public void setEveningTimePhone(String eveningTimePhone) {
		this.eveningTimePhone = eveningTimePhone;
	}

	/**
	 * @return dayTimePhone of String Type
	 */
	public String getDayTimePhone() {
		return dayTimePhone;
	}

	/**
	 * @param String
	 *            type set into dayTimePhone
	 */
	public void setDayTimePhone(String dayTimePhone) {
		this.dayTimePhone = dayTimePhone;
	}

	/**
	 * @return token of String Type
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param String
	 *            type set into token
	 */
	public void setToken(String token) {
		this.token = token;
	}

}
