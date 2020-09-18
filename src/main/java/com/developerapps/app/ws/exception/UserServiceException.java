/**
 * 
 */
package com.developerapps.app.ws.exception;

/**
 * @author anirudh.mathur
 *
 */
public class UserServiceException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -845340728215297812L;

	public UserServiceException(String message)
	{
		super(message);
	}
}
