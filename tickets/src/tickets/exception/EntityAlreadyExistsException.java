package tickets.exception;

public class EntityAlreadyExistsException extends Exception {

	public EntityAlreadyExistsException() {
	}

	public EntityAlreadyExistsException(String message) {
		super(message);
	}

	public EntityAlreadyExistsException(Throwable cause) {
		super(cause);
	}

	public EntityAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

}
