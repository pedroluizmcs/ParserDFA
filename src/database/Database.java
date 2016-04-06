package database;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import exception.StateNotFoundException;
import helper.Reader;
import helper.Writer;
import model.Automaton;
import model.State;
import model.Transition;

public class Database {

    private Automaton automaton;
    
    public Database() {
    	//this.populate();
    	this.automaton = new Automaton();
    }

	public void addState(State state) {
    	this.automaton.addState(state);
    	Writer writer = new Writer("data/states.txt");
    	writer.write(state.getName() + "|" + Boolean.toString(state.isInitial()) + "|" + Boolean.toString(state.isEnd()));
    	writer.close();
	}
    
    public void addTransition(Transition transition) {
		this.automaton.addTransition(transition);
		Writer writer = new Writer("data/transitions.txt");
		writer.write(transition.getStart().getName() + "|" + transition.getValue() + "|" + transition.getFinish().getName());
		writer.close();
    }
    
    
    public Automaton getAutomaton() {
    	return this.automaton;
    }
    
    public ArrayList<State> getStates() {
    	return this.automaton.getStates();
    }
    
    public State getStateByName(String name) throws StateNotFoundException {
    	return this.automaton.getStateByName(name);
    }
    
    private void populate() {
		this.automaton = new Automaton();
		this.fetchStates();
		this.fetchTransitions();
	}

    private void fetchStates() {
    	Reader reader = new Reader("data/states.txt");
    	for (String line : reader.readFile()) {
    		String[] array = line.split("\\|");
    		this.automaton.addState(new State(array[0], Boolean.parseBoolean(array[1]), Boolean.parseBoolean(array[2])));
    	}
	}
    
	private void fetchTransitions() {
		Reader reader = new Reader("data/transitions.txt");
		try {
			for (String line : reader.readFile()) {
				String[] split = line.split("\\|");
				this.automaton.addTransition(new Transition(split[0].charAt(0), this.automaton.getStateByName(split[1]), this.automaton.getStateByName(split[2])));
			}	
    	} catch (StateNotFoundException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
}
