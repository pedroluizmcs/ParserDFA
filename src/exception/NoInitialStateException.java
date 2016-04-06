package exception;

public class NoInitialStateException extends Exception {

	private String message;
	
	public NoInitialStateException() {
		this.message = "A initial state could not be found";
	}
	
	public String getMessage() {
		return message;
	}
}
