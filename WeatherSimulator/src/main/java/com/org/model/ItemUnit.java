/**
 * 
 */
package com.org.model;

import com.org.model.ItemUnit;

/**
 * @author MYPC
 *
 */
public enum ItemUnit {
	 HIGHEST, LOWEST;
	
	public static ItemUnit getUnit(String str) {
		switch (str.toLowerCase()) {
		case "highest":
			return HIGHEST;
		case "lowest":
			return LOWEST;
		default:
			return null;
		}

	}
}
