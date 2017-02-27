/* 
 * ===========================================================================
 * File Name Utility.java
 * 
 * Created on Aug 17, 2016
 *
 * This code contains copyright information which is the proprietary property
 * of ArtigemRS-FI. No part of this code may be reproduced, stored or transmitted
 * in any form without the prior written permission of ArtigemRS-FI.
 *
 * Copyright (C) Jubilation. 2016
 * All rights reserved.
 *
 * Modification history:
 * $Log: Utility.java,v $
 * ===========================================================================
 */
package com.nextgen.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.nextgen.enums.BaseAppConstants;

/**
* utility class for parsing the dates and getting the username
* 
* @author vikashk3 - Chetu
* @version 1.0 - Aug 17, 2016
*/

public class Utility {
	private static final Logger LOGGER = Logger.getLogger(Utility.class);

	/**parsing the date string into the date object 
	 * 
	 * @param dateParam				date string
	 * @return Date					date object from string 
	 */
	public static Date parseDate(String dateParam) {
		DateFormat df = new SimpleDateFormat(BaseAppConstants.DD_MM_YYYY.getValue());
		try {
			return df.parse(dateParam);
		} catch (ParseException e) {
			LOGGER.error("Exception while parsing", e);
		}
		return null;
	}
	
	/**to get random hex string 
	 * 
	 * @return String 						return some hexadecimal string
	 * @throws NoSuchAlgorithmException 
	 */
	public static String getRandomHexString(){
		 SecureRandom random;
		 byte [] bytes = new byte[5];
		try {
			random = SecureRandom.getInstance(BaseAppConstants.HEX_CHAR.getValue());
			random.nextBytes(bytes);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("Error in getting a random number...",e);
		}
		return byteArrayToHex(bytes);
    }
	
	/**
	 * @param bytes						byte array as a parameter to create a String		
	 * @return String 					HexaString
	 */
	private static String byteArrayToHex(byte[] bytes) {
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < bytes.length; i++) {
	 String theHex = Integer.toHexString(bytes[i] & 0xFF).toUpperCase();
	 sb.append(theHex.length() == 1 ? BaseAppConstants.ZERO.getValue()+ theHex : theHex);
	    }
	    LOGGER.info("Generated Random Hex String is  :  "+sb);
	    return sb.toString();
	}
	

}
