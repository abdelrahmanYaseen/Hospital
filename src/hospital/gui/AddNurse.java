package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import gui.panels.EmployeeInfoPanel;
import gui.panels.PersonalInfoPanel;
import hospital.HospitalManagementApplication;
import hospital.Nurse;
import hospital.Person;
import hospital.Senior;
import hospital.Util;

public class AddNurse extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<String> seniorsListModel;
	private JList<String> seniorsList;
	private Date birthday;
	
	private boolean validInput;

	/**
	 * Create the frame.
	 */
	public AddNurse(HospitalManagementApplication H) {
		setBounds(100, 100, 690, 710);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PersonalInfoPanel personalInfoPanel = new PersonalInfoPanel();
		personalInfoPanel.setBounds(25, 13, 264, 280);
		contentPane.add(personalInfoPanel);
		
		EmployeeInfoPanel employeeInfoPanel = new EmployeeInfoPanel();
		employeeInfoPanel.getTxtSpecialization().setText("null");
		employeeInfoPanel.getTxtSpecialization().setVisible(false);
		employeeInfoPanel.getLblSpecialization().setVisible(false);
		employeeInfoPanel.getTextAvailableLeaveDays().setText(""+20);
		employeeInfoPanel.setBounds(343, 13, 302, 280);
		contentPane.add(employeeInfoPanel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(254, 323, 207, 267);
		
		
		seniorsListModel = new DefaultListModel<String>();
		for (Person doctor : H.getDoctors()) {
			if(doctor instanceof Senior)
				seniorsListModel.addElement(doctor.getSsn());
		}
		seniorsList = new JList<String>(seniorsListModel);
		
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(seniorsList);
		
		JLabel lblWorksFor = new JLabel("Works for :");
		lblWorksFor.setBounds(129, 447, 95, 16);
		contentPane.add(lblWorksFor);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(personalInfoPanel.isFilled() && employeeInfoPanel.isFilled()){
					employeeInfoPanel.getTextAvailableLeaveDays().setText(""+20);
					if(H.isExist(personalInfoPanel.getTxtSsn().getText(), "Doctor")!=null || H.isExist(personalInfoPanel.getTxtSsn().getText(), "Nurse")!=null){
						JOptionPane.showMessageDialog(null, "ssn is used !");
					} else {
						try {
							validInput=true;
							birthday=Util.createDate(personalInfoPanel.getTxtDate().getText());
						} catch (ParseException i) {
							validInput=false;
							JOptionPane.showMessageDialog(null, "Wrong format for the birthday date !");
						}
						if(validInput){
							int salary=-1;
							try{
								salary =Integer.parseInt(employeeInfoPanel.getTxtSalary().getText());
							} catch (Exception r) {
								JOptionPane.showMessageDialog(null, "Salary must be a number !");
								validInput=false;
							}
							if(validInput){
								if(salary<3000 || salary>5000){
									validInput=false;
									JOptionPane.showMessageDialog(null, "Salary must be between 3000-5000 !");
								}
							}
							if(validInput){
								ArrayList<String> seniors = new ArrayList<String>();
								
								int[] selectedIx = seniorsList.getSelectedIndices();
								for(int i=0;i<selectedIx.length;i++){
									seniors.add((String) seniorsListModel.getElementAt(selectedIx[i]));
								}
								String ssn = personalInfoPanel.getTxtSsn().getText();
								String name=personalInfoPanel.getTxtName().getText();
								String gender;
								if(personalInfoPanel.getRdbtnMale().isSelected()){
									gender="Male";
								} else {
									gender = "Female";
								}
								String insuranceType;
								if(personalInfoPanel.getRdbtnFull().isSelected()){
									insuranceType = "Full";
								} else if(personalInfoPanel.getRdbtnPartial().isSelected()) {
									insuranceType = "Partial";
								} else {
									insuranceType = "Not Covered";
								}
								float salary1 = Float.parseFloat(employeeInfoPanel.getTxtSalary().getText());
								String department = employeeInfoPanel.getTxtDepartment().getText();
								
								
								Nurse n = new Nurse(ssn, name, gender, birthday, insuranceType, salary1, 20, department, seniors);
								H.getNurses().add(n);
								JOptionPane.showMessageDialog(null, "Added successfully");
								dispose();
							}
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Make sure that all the information are filled !");
				}
			}
		});
		btnAdd.setBounds(296, 613, 97, 25);
		contentPane.add(btnAdd);
		
		
	}
}
