package tickets.exception;

public class TicketNotValidException extends Exception {

	public TicketNotValidException() {
	}

	public TicketNotValidException(String message) {
		super(message);
	}

	public TicketNotValidException(Throwable cause) {
		super(cause);
	}

	public TicketNotValidException(String message, Throwable cause) {
		super(message, cause);
	}

	public TicketNotValidException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
