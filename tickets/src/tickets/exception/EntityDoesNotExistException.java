package tickets.exception;

public class EntityDoesNotExistException extends Exception {

	public EntityDoesNotExistException() {
	}

	public EntityDoesNotExistException(String message) {
		super(message);
	}

	public EntityDoesNotExistException(Throwable cause) {
		super(cause);
	}

	public EntityDoesNotExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EntityDoesNotExistException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
