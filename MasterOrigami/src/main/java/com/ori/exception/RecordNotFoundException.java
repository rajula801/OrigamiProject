package com.ori.exception;

public class RecordNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -171469795140864141L;

	public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(String message) {
        super(message);
    }

    public RecordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
