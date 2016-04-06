package model;

import java.util.ArrayList;

public class State {

    private String name;
    private boolean initial;
    private boolean end;

    public State(String name, boolean initial, boolean end) {
        this.name = name;
        this.initial = initial;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public boolean isInitial() {
        return initial;
    }

    public boolean isEnd() {
        return end;
    }
    
    public String toString() {
    	if (isEnd()) {
    		return "Sentence parsed successfully!";
    	}
    	return "The sentence could not be parsed.";
    }

}
