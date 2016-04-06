package model;

import exception.NoInitialStateException;
import exception.NoTransitionFoundException;
import exception.StateNotFoundException;

import java.util.ArrayList;

public class Automaton {

    private ArrayList<State> states;
    private ArrayList<Transition> transitions;

    public Automaton() {
        this.states = new ArrayList<State>();
        this.transitions = new ArrayList<Transition>();
    }

    public ArrayList<State> getStates() {
        return states;
    }
    
    public ArrayList<Transition> getTransitions() {
    	return transitions;
    }

    public void addState(State state) {
        this.states.add(state);
    }
    
    public void addTransition(Transition transition) {
    	this.transitions.add(transition);
    }

    public State getInitialState() throws NoInitialStateException{
    	for (State state : this.getStates()) {
    		if (state.isInitial())
    			return state;
    	}
    	throw new NoInitialStateException();
    }
    
    public State getStateByName(String name) throws StateNotFoundException {
    	for (State state : this.getStates()) {
    		if (state.getName().equals(name))
    			return state;
    	}
    	throw new StateNotFoundException(name);
    }
    
    public Transition findTransition(State start, Character value) throws NoTransitionFoundException {
    	for (Transition transition : this.transitions) {
    		if (transition.getStart().equals(start) && transition.getValue().equals(value))
    			return transition;
    	}
    	throw new NoTransitionFoundException();
    }

	public void setStates(ArrayList<State> states) {
		this.states = states;
	}

	public void setTransitions(ArrayList<Transition> transitions) {
		this.transitions = transitions;
	}
    
    

}