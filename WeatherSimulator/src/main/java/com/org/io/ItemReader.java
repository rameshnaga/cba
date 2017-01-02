/**
 * 
 */
package com.org.io;

import java.io.IOException;

/**
 * @author MYPC
 *
 */
public interface ItemReader<T> {
	public T readLine() throws IOException;
}