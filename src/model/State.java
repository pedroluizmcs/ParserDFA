package model;

import java.util.ArrayList;

public class State {

    private String name;
    private boolean start;
    private boolean end;
    private ArrayList<Transition> transitions;

    public State(String name, boolean start, boolean end) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.transitions = new ArrayList<Transition>();
    }

    public String getName() {
        return name;
    }

    public boolean isStart() {
        return start;
    }

    public boolean isEnd() {
        return end;
    }

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    public void addTransition(Transition transition) {
        this.transitions.add(transition);
    }
}
