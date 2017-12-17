package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hospital.HospitalManagementApplication;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddMenu extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public AddMenu(HospitalManagementApplication H) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnAddDoctor = new JButton("Add Doctor");
		btnAddDoctor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddDoctor addDoctor = new AddDoctor(H);
				addDoctor.setVisible(true);
			}
		});
		contentPane.add(btnAddDoctor);
		
		JButton btnAddPatient = new JButton("Add Patient");
		btnAddPatient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddPatient addPatient = new AddPatient(H);
				addPatient.setVisible(true);
			}
		});
		contentPane.add(btnAddPatient);
		
		JButton btnAddNurse = new JButton("Add Nurse");
		btnAddNurse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddNurse addNurse = new AddNurse(H);
				addNurse.setVisible(true);
			}
		});
		contentPane.add(btnAddNurse);
	}

}
