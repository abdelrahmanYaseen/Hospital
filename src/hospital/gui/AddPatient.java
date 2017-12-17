package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gui.panels.MedicalRecordPanel;
import gui.panels.PersonalInfoPanel;
import gui.panels.TreatmentPanel;
import hospital.HospitalManagementApplication;
import hospital.MedicalRecord;
import hospital.Patient;
import hospital.Util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class AddPatient extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstvisittohospital;
	private JTextField txtBloodpressure;
	
	private Date birthday;
	private Date firstVisit;
	private boolean validInput;


	/**
	 * Create the frame.
	 */
	public AddPatient(HospitalManagementApplication H) {
		setBounds(100, 100, 730, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PersonalInfoPanel personalInfoPanel = new PersonalInfoPanel();
		personalInfoPanel.setBounds(24, 13, 265, 272);
		contentPane.add(personalInfoPanel);
		
		JLabel lblFirstvisittohospital = new JLabel("First Visit To Hospital");
		lblFirstvisittohospital.setBounds(34, 305, 130, 16);
		contentPane.add(lblFirstvisittohospital);
		
		txtFirstvisittohospital = new JTextField();
		txtFirstvisittohospital.setBounds(176, 302, 116, 22);
		contentPane.add(txtFirstvisittohospital);
		txtFirstvisittohospital.setColumns(10);
		
		JLabel lblBloodPressure = new JLabel("Blood Pressure");
		lblBloodPressure.setBounds(34, 334, 130, 16);
		contentPane.add(lblBloodPressure);
		
		txtBloodpressure = new JTextField();
		txtBloodpressure.setBounds(176, 331, 116, 22);
		contentPane.add(txtBloodpressure);
		txtBloodpressure.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(24, 612, 97, 25);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnAdd);
		
		ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();
		
		
		String insuranceType;
		if(personalInfoPanel.getRdbtnFull().isSelected()){
			insuranceType = "Full";
		} else if(personalInfoPanel.getRdbtnPartial().isSelected()) {
			insuranceType = "Partial";
		} else {
			insuranceType = "Not Covered";
		}
		MedicalRecordPanel medicalRecordPanel = new MedicalRecordPanel(H,medicalRecords,insuranceType);
		contentPane.add(medicalRecordPanel);
		medicalRecordPanel.setBounds(332, 13, 331, 169);
		medicalRecordPanel.setVisible(true);
		medicalRecordPanel.getTxtRecordissuedate().setText("");		
		
		JLabel lblMedicalRecord = new JLabel("Medical Record ");
		lblMedicalRecord.setBounds(96, 13, 130, 16);
		medicalRecordPanel.add(lblMedicalRecord);
		
		JButton btnAddPatient = new JButton("Add");
		btnAddPatient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(personalInfoPanel.isFilled() && medicalRecords.size()>0){
					if(H.isExist(personalInfoPanel.getTxtSsn().getText(), "Patient")!=null){
						JOptionPane.showMessageDialog(null, "ssn is used !");
					} else {
						try {
							validInput=true;
							birthday=Util.createDate(personalInfoPanel.getTxtDate().getText());
						} catch (ParseException i) {
							validInput=false;
							JOptionPane.showMessageDialog(null, "Wrong format for the birthday date !");
						}
						try {
							validInput=true;
							firstVisit=Util.createDate(personalInfoPanel.getTxtDate().getText());
						} catch (ParseException i) {
							validInput=false;
							JOptionPane.showMessageDialog(null, "Wrong format for the First Visit date !");
						}
						if(validInput){
							String ssn = personalInfoPanel.getTxtSsn().getText();
							String name=personalInfoPanel.getTxtName().getText();
							String gender;
							if(personalInfoPanel.getRdbtnMale().isSelected()){
								gender="Male";
							} else {
								gender = "Female";
							}
							float bloodPressure=(float)0;
							try{
								bloodPressure = Float.parseFloat(txtBloodpressure.getText());
							} catch (Exception d) {
								JOptionPane.showMessageDialog(null, "blood pressure must be number !");
							}
							Patient p = new Patient(ssn,name,gender,birthday,insuranceType,bloodPressure,medicalRecords,firstVisit);
							H.getPatients().add(p);
							dispose();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Make sure to enter all the necessary info, and add at least one treatment");
				}
			}
		});
		btnAddPatient.setBounds(282, 408, 97, 25);
		contentPane.add(btnAddPatient);
		
	}
}
