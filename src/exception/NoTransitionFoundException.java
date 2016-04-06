package exception;

public class NoTransitionFoundException extends Exception {

	private String message;
	
	public NoTransitionFoundException() {
		this.message = "A matching transition could not be found.";
	}
	
	public String getMessage() {
		return message;
	}
}
