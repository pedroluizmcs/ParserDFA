package view;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;
import model.State;
import view.listener.FinishTransitionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class TransitionWindow extends JFrame {

	private Controller controller;
	private JPanel contentPane;
	private JComboBox statesStartCombo;
	private JComboBox statesFinishCombo;
	private JTextField valueFld;

	public TransitionWindow(Controller controller) {
		this.controller = controller;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 295, 165);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel startLbl = new JLabel("Start:");
		startLbl.setHorizontalAlignment(SwingConstants.CENTER);
		startLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		startLbl.setBounds(10, 10, 80, 30);
		contentPane.add(startLbl);
		
		statesStartCombo = new JComboBox();
		statesStartCombo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statesStartCombo.setBounds(10, 45, 80, 30);
		contentPane.add(statesStartCombo);
		
		statesFinishCombo = new JComboBox();
		statesFinishCombo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statesFinishCombo.setBounds(200, 45, 80, 30);
		contentPane.add(statesFinishCombo);
		
		JLabel finishLbl = new JLabel("Finish:");
		finishLbl.setHorizontalAlignment(SwingConstants.CENTER);
		finishLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		finishLbl.setBounds(200, 10, 80, 30);
		contentPane.add(finishLbl);
		
		JLabel valueLbl = new JLabel("Value:");
		valueLbl.setHorizontalAlignment(SwingConstants.CENTER);
		valueLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		valueLbl.setBounds(105, 10, 80, 30);
		contentPane.add(valueLbl);
		
		valueFld = new JTextField();
		valueFld.setFont(new Font("Tahoma", Font.PLAIN, 14));
		valueFld.setBounds(105, 45, 80, 30);
		contentPane.add(valueFld);
		valueFld.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 86, 400, 1);
		contentPane.add(separator);
		
		JButton finishTransitionBtn = new JButton("Finish");
		finishTransitionBtn.addActionListener(new FinishTransitionListener(this.controller, this));
		finishTransitionBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		finishTransitionBtn.setBounds(10, 98, 270, 30);
		contentPane.add(finishTransitionBtn);
		
		this.populateStatesCombo();
		
		setVisible(true);
		setResizable(false);
	}
	
	public Character getValue() {
		return this.valueFld.getText().toUpperCase().charAt(0);
	}
	
	public String getStart() {
		return this.statesStartCombo.getSelectedItem().toString();
	}
	
	public String getFinish() {
		return this.statesFinishCombo.getSelectedItem().toString();
	}
	
	private void populateStatesCombo() {
		for (State state : this.controller.getStates()) {
			this.statesStartCombo.addItem(state.getName());
			this.statesFinishCombo.addItem(state.getName());
		}
	}
}
