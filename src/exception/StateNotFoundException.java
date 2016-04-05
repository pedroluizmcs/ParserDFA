package exception;

public class StateNotFoundException extends Exception {

    private String message;

    public StateNotFoundException(String name) {
        this.message = "A state with the name + \"" + name + "\" could not be found.";
    }
}
