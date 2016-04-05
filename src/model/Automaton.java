package model;

import exception.StateNotFoundException;

import java.util.ArrayList;

public class Automaton {

    private ArrayList<String> prefixes;
    private ArrayList<String> substrings;
    private ArrayList<String> suffixes;
    private ArrayList<State> states;

    public Automaton() {
        this.prefixes = new ArrayList<String>();
        this.substrings = new ArrayList<String>();
        this.suffixes = new ArrayList<String>();
        this.states = new ArrayList<State>();
    }

    public ArrayList<String> getPrefixes() {
        return prefixes;
    }

    public ArrayList<String> getSubstrings() {
        return substrings;
    }

    public ArrayList<String> getSuffixes() {
        return suffixes;
    }

    public ArrayList<State> getStates() {
        return states;
    }

    public void addPrefix(String prefix) {
        this.prefixes.add(prefix);
    }

    public void addSubstring(String substring) {
        this.substrings.add(substring);
    }

    public void addSuffix(String suffix) {
        this.suffixes.add(suffix);
    }

    public void addState(State state) {
        this.states.add(state);
    }

    public State getState(String name) throws StateNotFoundException {
        for (State state : this.states) {
            if (state.getName().equals(name))
                return state;
        }
        throw new StateNotFoundException(name);
    }

}