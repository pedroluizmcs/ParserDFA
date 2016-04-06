package view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Controller;

public class AddStateListener implements ActionListener {

	private Controller controller;
	
	public AddStateListener(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controller.createStateWindow();
	}

}
