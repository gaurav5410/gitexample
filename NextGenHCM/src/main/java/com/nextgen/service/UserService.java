/* 
 * ===========================================================================
 * File Name UserService.java
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
 * $Log: UserService.java,v $
 * ===========================================================================
 */

package com.nextgen.service;

import com.nextgen.dto.CreateEmployeeDTO;
import com.nextgen.exception.ApplicationCustomException;

/**
 * Service interface is to have all the abstract methods related to user.
 * 
 * @author gauravk - Chetu
 * @version 1.0 - Jul 22, 2016
 */

public interface UserService {

	/**This method is used to create a worker into the system.
	 * 
	 * @param createEmployeeDTO						worker related information to create the worker
	 * @return createEmployeeDTO						worker information after creating the worker into the system.
	 * @throws ApplicationCustomException 
	 */
	public CreateEmployeeDTO createEmployee(final CreateEmployeeDTO createEmployeeDTO) throws ApplicationCustomException;

	
	/**This method is used to update a worker into the system.
	 * 
	 * @param createEmployeeDTO						worker related information to create the worker
	 * @return createEmployeeDTO						worker information after creating the worker into the system.
	 * @throws ApplicationCustomException 
	 */
	public CreateEmployeeDTO updateEmployee(final CreateEmployeeDTO createEmployeeDTO) throws ApplicationCustomException;

}
