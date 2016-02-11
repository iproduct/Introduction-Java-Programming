package tickets.exception;

public class EntityAlreadyExistsException extends Exception {

	public EntityAlreadyExistsException() {
	}

	public EntityAlreadyExistsException(String message) {
		super(message);
	}

	public EntityAlreadyExistsException(Throwable arg0) {
		super(arg0);
	}

	public EntityAlreadyExistsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EntityAlreadyExistsException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
