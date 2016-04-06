package view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Controller;
import model.State;
import view.StateWindow;

public class FinishStateListener implements ActionListener {

	private Controller controller;
	private StateWindow stateWindow;
	
	public FinishStateListener(Controller controller, StateWindow stateWindow) {
		this.controller = controller;
		this.stateWindow = stateWindow;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controller.registerState(new State(stateWindow.getName(), stateWindow.isInitial(), stateWindow.isEnd()));
		this.stateWindow.setVisible(false);
		this.stateWindow = null;
	}

}
