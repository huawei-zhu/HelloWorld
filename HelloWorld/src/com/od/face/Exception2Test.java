package com.od.face;

import org.apache.log4j.Logger;

import com.officedepot.jops.exceptions.CDAPException;
import com.officedepot.jops.exceptions.ODApplicationException;
import com.officedepot.jops.exceptions.ODErrors;
import com.officedepot.jops.exceptions.ODSystemException;

public class Exception2Test {
	
	private static Logger logger = Logger.getLogger(Exception2Test.class);  

	public static void main(String[] args) {
		try {
			method();
		} catch (Exception oe) {
			oe.printStackTrace();
		}
	}
	
	public static void method() {
		try {
			getOrderTotals();
		}catch(OrderException o) {
			Throwable rootEx = o;
			if (o.getCause() != null) {
				rootEx = o.getCause();
			}
			logger.error("Unable to Get GiftCard list OrderException : " + o.getMessage(), rootEx);
		} catch (Exception oe) {
			Throwable rootEx = oe;
			if (oe.getCause() != null) {
				rootEx = oe.getCause();
			}
			logger.error("Unable to Get GiftCard list Exception : " + oe.getMessage(), rootEx);
		}
	}

	public static void getOrderTotals() {
		try {
			getOrderTotals1();
		} catch (OrderException exp) {
			throw exp;
		} catch (RuntimeException exp) {
			throw new ODSystemException(exp.getMessage(), exp);
		}
	}

	public static void getOrderTotals1() {
		try {
			processOrderSubmit();
		} catch (ODApplicationException exp) {
			Throwable rootEx = exp;
			while (rootEx.getCause() != null) {
				rootEx = rootEx.getCause();
			}
			throw new OrderException(exp.getErrorCode(), exp.getMessage(), rootEx);
		} catch (Exception exp) {
			throw new OrderException("", exp.getMessage(), exp);
		}
//		} catch (ODSystemException exp) {
//			Throwable rootEx = exp;
//			if (exp.getCause() != null && exp.getCause() instanceof ODSystemException) {
//				rootEx = exp.getCause();
//			}
//			throw new ODSystemException(exp.getErrorSource(), exp.getErrorCode(), exp.getMessage(), rootEx);
//		}
	}

	static int orderInfos = 0;

	public static void processOrderSubmit() {
		submit();
		if (orderInfos == 0) {
			logger.error("SubmitOrder failed to return an OrderInfoCollection. orderInfos.size() = ");
			throw new OrderBookingException("SubmitOrder", "99", "There was a problem placing your order. Please try again.");
		}
	}
	
	public static void submit() {
		try {
			submitOrderBlock();
		} catch (ODSystemException e) {
			throw new OrderBookingException(e.getErrorSource(), e.getErrorCode(), e.getErrorMsg(), e);
		}
	}
	
	public static void submitOrderBlock() {
		try {
			processSubmitMsgError();
		} catch (MessageException me) {
			logger.error("CDAP submitOrder message exception: ", me);
			throw new CDAPException(me.getMessage());
		}
	}

	static int i = 11;
	static int j = 11;
	public static void processSubmitMsgError() {
		if (i == 1) {
			if (j == 1){
				throw new OrderBookingException("jjjjj", "jjjjj", "jjjjjjjj");
			} else {
				throw new CDAPException("no jjjjj", "no jjjjj", "no jjjjjjjj");
			}
		}
	}
	
	static class MessageException extends RuntimeException {
		public MessageException() {
			super();
		}

		public MessageException(String msg) {
			super(msg);
		}
		
		public MessageException(String msg, Throwable cause){
			super(msg,cause);
		}
	}
	
	static class OrderException extends ODApplicationException {

		/**
		 * Constructor for OrderException.
		 */
		public OrderException(String errorCode, String errorMsg) {
			super(errorCode, errorMsg);
		}
		
		public OrderException(String errorCode, String errorMsg, Throwable paramThrowable) {
			super(errorCode, errorMsg, paramThrowable);
		}
	}
	
	static class OrderBookingException extends ODApplicationException {

		public OrderBookingException(String message, Throwable cause) {
			super(message, cause);
		}

		public OrderBookingException(String errorSource, String errorCode, String message) {
			super(errorSource, errorCode, message);
		}

		public OrderBookingException(String message) {
			super(message);
		}

		public String getErrorKeyPrefix() {
			return OrderBookingException.class.getName();
		}

		public OrderBookingException(String errorSource, String errorCode, String message, Throwable t) {
			super(errorSource, errorCode, message, t);
		}

	}
	
	static class AccountServiceException extends ODApplicationException {

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


}


