package control;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.Database;
import exception.NoInitialStateException;
import exception.NoTransitionFoundException;
import exception.StateNotFoundException;
import model.Automaton;
import model.State;
import model.Transition;
import view.AutomatonWindow;
import view.StateWindow;
import view.TransitionWindow;

public class Controller {

    private Database database;
    private AutomatonWindow automatonWindow;
    private StateWindow stateWindow;
    private TransitionWindow transitionWindow;

    public Controller() {
    	//this.createFiles();
        this.database = new Database();
        this.automatonWindow = new AutomatonWindow(this);
        
    }

	public void createStateWindow() {
		this.stateWindow = new StateWindow(this);
	}

	public void registerState(State state) {
		this.database.addState(state);
		this.automatonWindow.addState(state);
	}

	public void createTransitionWindow() {
		this.transitionWindow = new TransitionWindow(this);
		
	}
	
	public ArrayList<State> getStates() {
		return this.database.getStates();
	}
	
	public State getStateByName(String name) throws StateNotFoundException {
		return this.database.getStateByName(name);
	}

	public void registerTransition(Transition transition) {
		this.database.addTransition(transition);
		this.automatonWindow.addTransition(transition);
	}

	public char[] createParsingWindow() {
		return JOptionPane.showInputDialog(this.automatonWindow.getContentPane(), "Input the sentence to be parsed:").toUpperCase().toCharArray();
	}

	public void parse(char[] sentence) {
		try {
			Automaton dfa = this.database.getAutomaton();
			State current = dfa.getInitialState();
			StringBuilder string = new StringBuilder();
			for (char character : sentence) {
				Transition transition = dfa.findTransition(current, character);
				string.append((transition.toString()) + "\n");
				current = transition.getFinish();
			}
			JOptionPane.showMessageDialog(this.automatonWindow.getContentPane(), string + current.toString());
		} catch (NoInitialStateException ex) {
			ex.getMessage();
			ex.printStackTrace();	
		} catch (NoTransitionFoundException ex1) {
			ex1.getMessage();
			ex1.printStackTrace();
		}	
	}
	
	private void createFiles() {
		try {
			new File("data").mkdirs();
			new File("data/states.txt").createNewFile();
			new File("data/transitions.txt").createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
}
