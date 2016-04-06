package view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Controller;

public class AddTransitionListener implements ActionListener {

	private Controller controller;
	
	public AddTransitionListener(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controller.createTransitionWindow();

	}

}
