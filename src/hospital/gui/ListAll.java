package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import hospital.HospitalManagementApplication;

public class ListAll extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public ListAll(HospitalManagementApplication H) {
		setBounds(100, 100, 910, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoctors = new JLabel("Doctors ");
		lblDoctors.setBounds(122, 13, 56, 16);
		contentPane.add(lblDoctors);
		
		JLabel lblNurses = new JLabel("Nurses");
		lblNurses.setBounds(420, 13, 56, 16);
		contentPane.add(lblNurses);
		
		JLabel lblPatients = new JLabel("Patients");
		lblPatients.setBounds(704, 13, 56, 16);
		contentPane.add(lblPatients);
		
		JTextArea txtrDoctors = new JTextArea();
		txtrDoctors.setLineWrap(true);
		txtrDoctors.setBounds(285, 151, 153, 307);
		txtrDoctors.setText(H.getDoctors().toString());
		
		JScrollPane scrollPane_doctors = new JScrollPane();
		scrollPane_doctors.setBounds(24, 58, 255, 496);
		scrollPane_doctors.setViewportView(txtrDoctors);
		contentPane.add(scrollPane_doctors);
		
		JTextArea txtpnNurses = new JTextArea();
		txtpnNurses.setLineWrap(true);
		txtpnNurses.setBounds(325, 60, 255, 494);
		txtpnNurses.setText(H.getNurses().toString());
		
		JScrollPane scrollPane_nurses = new JScrollPane();
		scrollPane_nurses.setBounds(316, 58, 255, 496);
		scrollPane_nurses.setViewportView(txtpnNurses);
		contentPane.add(scrollPane_nurses);
		
		JTextArea txtpnPatients = new JTextArea();
		txtpnPatients.setLineWrap(true);
		txtpnPatients.setBounds(325, 60, 255, 496);
		txtpnPatients.setText(H.getPatients().toString());
		
		JScrollPane scrollPane_patients = new JScrollPane();
		scrollPane_patients.setBounds(607, 58, 255, 496);
		scrollPane_patients.setViewportView(txtpnPatients);
		contentPane.add(scrollPane_patients);
		
	}
}
