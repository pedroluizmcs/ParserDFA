package view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Controller;
import exception.StateNotFoundException;
import model.Transition;
import view.TransitionWindow;

public class FinishTransitionListener implements ActionListener {

	private Controller controller;
	private TransitionWindow transitionWindow;
	
	public FinishTransitionListener(Controller controller, TransitionWindow transitionWindow) {
		this.controller = controller;
		this.transitionWindow = transitionWindow;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			this.controller.registerTransition(new Transition(transitionWindow.getValue(), 
															  controller.getStateByName(transitionWindow.getStart()), 
															  controller.getStateByName(transitionWindow.getFinish())));
			this.transitionWindow.setVisible(false);
			this.transitionWindow = null;
		} catch (StateNotFoundException ex) {
			ex.getMessage();
			ex.printStackTrace();
		}
		
	}

}
