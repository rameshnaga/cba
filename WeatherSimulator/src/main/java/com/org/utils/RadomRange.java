/**
 * 
 */
package com.org.utils;

import java.util.Random;

/**
 * @author MYPC
 *
 */
public class RadomRange {
	public static int randInt(int min, int max) {

	    Random rand = new Random();

	   
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
