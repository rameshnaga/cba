/**
 * 
 */
package com.org.utils;

import com.org.utils.RadomRange;

/**
 * @author MYPC
 *
 */
public class RainfallUtils {

	public  static String checkCondition( int month, double temperature){
		int randomInt = RadomRange.randInt(0, 100);
		boolean rainning =false;
		if (month < 8 && randomInt<=25)
			rainning = true;
		else if (month > 8 && randomInt<15)
			rainning = true;
		if (rainning) 
			if (temperature>0) return "Rain";
			else return "Snow";
		
		return "Sunny";
	}
}
