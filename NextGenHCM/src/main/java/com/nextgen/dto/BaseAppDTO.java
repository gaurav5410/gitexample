/* 
 * ===========================================================================
 * File Name BaseAppDTO.java
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
 * $Log: BaseAppDTO.java,v $
 * ===========================================================================
 */

package com.nextgen.dto;

import java.io.Serializable;

import org.springframework.transaction.annotation.Transactional;

/**
 * This class contains the details of application basic select menu data.
 * 
 * @author gauravk - Chetu
 * @version 1.0 - Jul 14, 2016
 */

@Transactional
public class BaseAppDTO implements Serializable {

	private static final long serialVersionUID = 8260923036454345537L;
	private Long id;
	private String name;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
