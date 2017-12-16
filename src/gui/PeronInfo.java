package gui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class PeronInfo extends JPanel {
	private JTextField txtName;
	private JTextField txtSsn;

	/**
	 * Create the panel.
	 */
	public PeronInfo() {
		setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(44, 12, 450, 30);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(44, 40, 450, 30);
		txtName.setToolTipText("Enter the name");
		add(txtName);
		txtName.setColumns(5);
		
		JLabel lblSsn = new JLabel("SSN");
		lblSsn.setBounds(44, 71, 450, 30);
		lblSsn.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblSsn);
		
		txtSsn = new JTextField();
		txtSsn.setBounds(44, 102, 450, 30);
		txtName.setToolTipText("Enter the SSN");
		add(txtSsn);
		txtSsn.setColumns(5);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(237, 161, 70, 15);
		add(lblGender);
		

	}
}
