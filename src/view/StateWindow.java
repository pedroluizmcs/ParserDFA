package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.Controller;
import view.listener.FinishStateListener;

public class StateWindow extends JFrame {

	private Controller controller;
	private JPanel contentPane;
	private JTextField nameFld;
	private JCheckBox initialCheck;
	private JCheckBox endCheck;

	public StateWindow(Controller controller) {
		this.controller = controller;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 150, 151);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameLbl = new JLabel("Name:");
		nameLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLbl.setBounds(10, 10, 45, 30);
		contentPane.add(nameLbl);
		
		nameFld = new JTextField();
		nameFld.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameFld.setBounds(55, 10, 80, 30);
		contentPane.add(nameFld);
		nameFld.setColumns(10);
		
		initialCheck = new JCheckBox("Initial");
		initialCheck.setFont(new Font("Tahoma", Font.PLAIN, 14));
		initialCheck.setBounds(10, 50, 60, 30);
		contentPane.add(initialCheck);
		
		endCheck = new JCheckBox("Final");
		endCheck.setFont(new Font("Tahoma", Font.PLAIN, 14));
		endCheck.setBounds(80, 50, 55, 30);
		contentPane.add(endCheck);
		
		JButton finishStateBtn = new JButton("Finish");
		finishStateBtn.addActionListener(new FinishStateListener(this.controller, this));
		finishStateBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		finishStateBtn.setBounds(10, 87, 125, 30);
		contentPane.add(finishStateBtn);
		setVisible(true);
		setResizable(false);
	}

	public String getName() {
		return nameFld.getText().toUpperCase();
	}

	public boolean isInitial() {
		return this.initialCheck.isSelected();
	}
	
	public boolean isEnd() {
		return this.endCheck.isSelected();
	}
	
	
	
	
	
}
