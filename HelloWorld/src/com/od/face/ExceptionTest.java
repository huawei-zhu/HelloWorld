package com.od.face;

import org.apache.log4j.Logger;

import com.officedepot.jops.exceptions.ODApplicationException;
import com.officedepot.jops.exceptions.ODErrors;
import com.officedepot.jops.exceptions.ODSystemException;

public class ExceptionTest {
	
	private static Logger logger = Logger.getLogger(ExceptionTest.class);  

	public static void main(String[] args) {
		try {
			createAccount();
		} catch (Exception e) {
			//throw e;
		}
	}

	public static void createAccount() {
		try {
			createAccount1();
		} catch (Exception exp) {
			logger.error("Unhandled exception: " + exp, exp.getCause());
		}
	}

	public static void createAccount1() {
		try {
			try {
				createBillingInfo();
			} catch (AccountServiceException ex) {
				Throwable rootEx = ex;
				if (ex.getCause() != null && ex.getCause() instanceof AccountServiceException) {
					rootEx = ex.getCause();
				}
				throw new ODSystemException(ex.getErrorSource(), ex.getErrorCode(), ex.getMessage(), rootEx);
			}
		} catch (ODSystemException exp) {
			Throwable rootEx = exp;
			if (exp.getCause() != null && exp.getCause() instanceof ODSystemException) {
				rootEx = exp.getCause();
			}
			throw new ODSystemException(exp.getErrorSource(), exp.getErrorCode(), exp.getMessage(), rootEx);
		}
	}

	public static void createBillingInfo() {
		try {
			processMsgError();
		} catch (AccountServiceException me) {
			throw new AccountServiceException("2222", "22222", me.getLocalizedMessage(), me);
		}
	}

	public static void processMsgError() {
		try {
			String s = null;
			s.getBytes();
		} catch (Exception msg) {
			throw new AccountServiceException("1111", "1111",  "my root reason");
		}
	}

}

class AccountServiceException extends ODApplicationException {

	private static final long serialVersionUID = 1L;

	public AccountServiceException(String errorCode, String message) {
		super(errorCode, message);
	}

	public AccountServiceException(String message) {
		super(message);
	}

	public AccountServiceException(String errorSource, String errorCode, String message) {
		super(errorSource, errorCode, message);
	}

	public AccountServiceException(String errorSource, String errorCode, String message, ODErrors oDerrors) {
		super(errorSource, errorCode, oDerrors, message);
	}

	public AccountServiceException() {
		super();
	}

	public AccountServiceException(String errorSource, String errorCode, String message, Throwable cause) {
		super(errorSource, errorCode, message, cause);
	}

	public String getErrorKeyPrefix() {
		return AccountServiceException.class.getName();
	}

}

