package maze;

public class InvalidMazeFileFormatException extends Exception {

	public InvalidMazeFileFormatException() {
		super();
	}

	public InvalidMazeFileFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidMazeFileFormatException(String message) {
		super(message);
	}

	public InvalidMazeFileFormatException(Throwable cause) {
		super(cause);
	}

}
