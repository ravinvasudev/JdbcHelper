package rv.jdbchelper;

import rv.jdbchelper.Constants.ResponseCode;

/**
 * Custom exception class to personalize messages.
 *
 */
public final class JdbcException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private ResponseCode code;
	
	public JdbcException() {
		super();
	}

	public JdbcException(String message) {
		super(message);
	}

	public JdbcException(ResponseCode code, String message) {
		super(message);
		this.code = code;
	}

	public JdbcException(ResponseCode code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}	

	public ResponseCode getResponseCode() {
		return this.code;
	}
}