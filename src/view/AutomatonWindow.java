package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import control.Controller;
import model.State;
import model.Transition;
import view.listener.AddStateListener;
import view.listener.AddTransitionListener;
import view.listener.FinishAutomatonListener;

public class AutomatonWindow extends JFrame {

	private Controller controller;
	private JPanel contentPane;
	private JComboBox statesCombo;
	private JComboBox transitionsCombo;

	public AutomatonWindow(Controller controller) {
		this.controller = controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addStateBtn = new JButton("Add State");
		addStateBtn.addActionListener(new AddStateListener(this.controller));
		addStateBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addStateBtn.setBounds(10, 50, 125, 30);
		contentPane.add(addStateBtn);
		
		JButton finishBtn = new JButton("Finish");
		finishBtn.addActionListener(new FinishAutomatonListener(this.controller));
		finishBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		finishBtn.setBounds(10, 101, 355, 35);
		contentPane.add(finishBtn);
		
		statesCombo = new JComboBox();
		statesCombo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statesCombo.setBounds(65, 10, 70, 30);
		contentPane.add(statesCombo);
		
		JLabel statesLbl = new JLabel("States:");
		statesLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statesLbl.setBounds(10, 10, 70, 30);
		contentPane.add(statesLbl);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 90, 500, 1);
		contentPane.add(separator);
		
		JLabel transitionsLbl = new JLabel("Transitions:");
		transitionsLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		transitionsLbl.setBounds(160, 10, 70, 30);
		contentPane.add(transitionsLbl);
		
		transitionsCombo = new JComboBox();
		transitionsCombo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		transitionsCombo.setBounds(240, 10, 125, 30);
		contentPane.add(transitionsCombo);
		
		JButton addTransitionBtn = new JButton("Add Transition");
		addTransitionBtn.addActionListener(new AddTransitionListener(this.controller));
		addTransitionBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addTransitionBtn.setBounds(160, 50, 205, 30);
		contentPane.add(addTransitionBtn);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(147, 0, 1, 90);
		contentPane.add(separator_1);
		setVisible(true);
		setResizable(false);
	}
	
	public void addState(State state) {
		this.statesCombo.addItem(state.getName());
	}
	
	public void addTransition(Transition transition) {
		this.transitionsCombo.addItem(transition.toString());
	}
}
