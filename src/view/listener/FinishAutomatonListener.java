package view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Controller;

public class FinishAutomatonListener implements ActionListener {

	private Controller controller;
	
	public FinishAutomatonListener(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.controller.parse(this.controller.createParsingWindow());

	}

}
