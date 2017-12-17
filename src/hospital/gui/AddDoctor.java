package gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

import gui.panels.EmployeeInfoPanel;
import gui.panels.JuniorInfoPanel;
import gui.panels.PersonalInfoPanel;
import gui.panels.SeniorInfoPanel;
import hospital.Doctor;
import hospital.HospitalManagementApplication;
import hospital.Junior;
import hospital.Senior;
import hospital.Util;

public class AddDoctor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Date birthday;
	private Date startDate;
	private Date endDate;
	
	private boolean validInput;


	/**
	 * Create the frame.
	 */
	public AddDoctor(HospitalManagementApplication H) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 669);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PersonalInfoPanel personalInfopanel = new PersonalInfoPanel();
		personalInfopanel.setBounds(26, 28, 278, 269);
		contentPane.add(personalInfopanel);
		
		EmployeeInfoPanel employeeInfoPanel = new EmployeeInfoPanel();
		employeeInfoPanel.setBounds(24, 310, 280, 190);
		contentPane.add(employeeInfoPanel);
		
		JuniorInfoPanel juniorInfoPanel = new JuniorInfoPanel(H);
		juniorInfoPanel.setBounds(401, 30, 364, 356);
		juniorInfoPanel.setVisible(false);
		
		SeniorInfoPanel seniorInfoPanel = new SeniorInfoPanel(H);
		seniorInfoPanel.setBounds(401, 58, 364, 313);
		contentPane.add(seniorInfoPanel);
		seniorInfoPanel.setVisible(true);
		contentPane.add(juniorInfoPanel);
		
		JRadioButton rdbtnJunior = new JRadioButton("Junior");
		rdbtnJunior.setBounds(26, 531, 127, 25);
		contentPane.add(rdbtnJunior);
		
		JRadioButton rdbtnSenior = new JRadioButton("Senior");
		rdbtnSenior.setSelected(true);
		rdbtnSenior.setBounds(173, 531, 127, 25);
		contentPane.add(rdbtnSenior);
		
		
		rdbtnJunior.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					juniorInfoPanel.setVisible(true);
					seniorInfoPanel.setVisible(false);
			    }
			    else if (e.getStateChange() == ItemEvent.DESELECTED) {
			        juniorInfoPanel.setVisible(false);
			        seniorInfoPanel.setVisible(true);
			    }
			}
		});
		employeeInfoPanel.getTextAvailableLeaveDays().setText(""+25);

		ButtonGroup positionGroup = new ButtonGroup();
		positionGroup.add(rdbtnJunior);
		positionGroup.add(rdbtnSenior);
		
		
		JButton btnAdd = new JButton("Add");
		validInput = false;
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!personalInfopanel.isFilled() || !employeeInfoPanel.isFilled() || (rdbtnJunior.isSelected()==true && !juniorInfoPanel.isFilled()) || (rdbtnJunior.isSelected()==false && !seniorInfoPanel.isFilled()))
					JOptionPane.showMessageDialog(null, "Make sure that all the information are filled !");
				else
					{
						if(H.isExist(personalInfopanel.getTxtSsn().getText(), "Doctor")!=null || H.isExist(personalInfopanel.getTxtSsn().getText(), "Nurse")!=null){
							JOptionPane.showMessageDialog(null, "ssn is used !");
						} else {
							try {
								validInput=true;
								birthday=Util.createDate(personalInfopanel.getTxtDate().getText());
							} catch (ParseException e) {
								validInput=false;
								JOptionPane.showMessageDialog(null, "Wrong format for the birthday date !");
							}
							if(validInput){
								if(rdbtnJunior.isSelected()){
									try {
										validInput=true;
										startDate=Util.createDate(juniorInfoPanel.getTxtStartDate().getText());
									} catch (ParseException e) {
										validInput=false;
										JOptionPane.showMessageDialog(null, "Wrong format for the start date !");
									}
									if(validInput){
										try {
											validInput=true;
											endDate=Util.createDate(juniorInfoPanel.getTxtEndDate().getText());
										} catch (ParseException e) {
											validInput=false;
											JOptionPane.showMessageDialog(null, "Wrong format for the end date !");
										}
									} if(validInput){
										int salary=-1;
										try{
											salary =Integer.parseInt(employeeInfoPanel.getTxtSalary().getText());
										} catch (Exception e) {
											JOptionPane.showMessageDialog(null, "Salary must be a number !");
											validInput=false;
										}
										if(validInput){
											if(salary<5000 || salary>10000){
												validInput=false;
												JOptionPane.showMessageDialog(null, "Salary must be between 5000-1000 !");
											}
										}
										
									}
								} else {
									int salary=-1;
									try{
										salary =Integer.parseInt(employeeInfoPanel.getTxtSalary().getText());
									} catch (Exception e) {
										JOptionPane.showMessageDialog(null, "Salary must be a number !");
										validInput=false;
									}
									if(validInput){
										if(salary<10000 || salary>20000){
											validInput=false;
											JOptionPane.showMessageDialog(null, "Salary must be between 10000-20000 !");
										}
									}
								}
								if(validInput){
									String name = personalInfopanel.getTxtName().getText();
									String ssn = personalInfopanel.getTxtSsn().getText();
									String gender;
									if(personalInfopanel.getRdbtnFemale().isSelected()){
										gender="Female";
									} else {
										gender = "Male";
									}
									String insuranceType;
									if(personalInfopanel.getRdbtnFull().isSelected()){
										insuranceType = "Full";
									} else if(personalInfopanel.getRdbtnPartial().isSelected()) {
										insuranceType = "Partial";
									} else {
										insuranceType = "Not Covered";
									}
									int availableLeaveDays =25;
									int salary = Integer.parseInt(employeeInfoPanel.getTxtSalary().getText());
									String department = employeeInfoPanel.getTxtDepartment().getText();
									String specialization = employeeInfoPanel.getTxtSpecialization().getText();
									Doctor d = new Doctor(ssn,name,gender,insuranceType,birthday,availableLeaveDays,salary,department,specialization);
									String superviserSSN = juniorInfoPanel.getList().getSelectedValue();
									if(rdbtnJunior.isSelected()){
										Junior j = new Junior(d, startDate, endDate, superviserSSN);
										H.doctors.add(j);
									} else {
										ArrayList<String> nurses = new ArrayList<String>();
										ListModel<String> model=seniorInfoPanel.getList().getModel();
										int[] selectedIx = seniorInfoPanel.getList().getSelectedIndices();
										for(int i=0;i<selectedIx.length;i++){
											nurses.add((String) model.getElementAt(selectedIx[i]));
										}
										String employmentHistory = seniorInfoPanel.getTxtpnEmploymentHistory().getText();
										Senior s = new Senior(d, employmentHistory, nurses);
										H.doctors.add(s);
										H.listDoctors();
									}
									JOptionPane.showMessageDialog(null, "Added Successfully !");
									dispose();
								}
							}
						}
					}
			}
		});
		btnAdd.setBounds(394, 454, 312, 128);
		contentPane.add(btnAdd);
		
	}
}
