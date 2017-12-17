package gui.panels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import gui.AddTreatment;
import gui.AddTreatmentDialog;
import hospital.HospitalManagementApplication;
import hospital.MedicalRecord;
import hospital.Treatment;
import hospital.Util;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MedicalRecordPanel extends JPanel {
	private JTextField txtRecordissuedate;
	private Date issueDate;
	
	private boolean validInput;
	/**
	 * @return the txtRecordissuedate
	 */
	public JTextField getTxtRecordissuedate() {
		return txtRecordissuedate;
	}

	/**
	 * @param txtRecordissuedate the txtRecordissuedate to set
	 */
	public void setTxtRecordissuedate(JTextField txtRecordissuedate) {
		this.txtRecordissuedate = txtRecordissuedate;
	}

	/**
	 * Create the panel.
	 */
	public MedicalRecordPanel(HospitalManagementApplication H ,ArrayList<MedicalRecord> medicalRecords,String insuranceType) {
		setLayout(null);
		
		JLabel lblTreatments = new JLabel("Treatments ");
		lblTreatments.setBounds(45, 96, 109, 22);
		add(lblTreatments);
		
		JLabel lblTreatmentsCount = new JLabel("0");
		lblTreatmentsCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblTreatmentsCount.setBounds(45, 118, 56, 16);
		add(lblTreatmentsCount);
		ArrayList<Treatment> treatments = new ArrayList<Treatment>();
		JButton btnAddTreatment = new JButton("Add Treatment");
		btnAddTreatment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		validInput=false;
		btnAddTreatment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!txtRecordissuedate.getText().equals("")){
					try {
						int size = treatments.size();
						issueDate=Util.createDate(txtRecordissuedate.getText());
//						AddTreatment addTreatment = new AddTreatment(H,treatments,insuranceType);
						AddTreatmentDialog addTreatmentDialog = new AddTreatmentDialog(H,treatments,insuranceType);
						addTreatmentDialog.setVisible(true);
						System.out.println("Exadasd");
//						addTreatment.setVisible(true);
						if(treatments.size()>size){
							validInput=true;
							lblTreatmentsCount.setText(""+treatments.size());
						}
					} catch (ParseException i) {
						JOptionPane.showMessageDialog(null, "Wrong format for the issue date !");
						validInput=false;
					}
				} else  {
					validInput=false;
					JOptionPane.showMessageDialog(null, "You must specify the issue date of the record !");
				}
				
				if(validInput){
					MedicalRecord medicalRecord = new MedicalRecord(issueDate,treatments);
					medicalRecords.add(medicalRecord);
				}
			}
		});
		btnAddTreatment.setBounds(195, 96, 127, 23);
		add(btnAddTreatment);
		
		JLabel lblRecordIssueDate = new JLabel("Record Issue Date :");
		lblRecordIssueDate.setBounds(45, 45, 127, 16);
		add(lblRecordIssueDate);
		
		txtRecordissuedate = new JTextField();
		txtRecordissuedate.setBounds(195, 42, 116, 22);
		add(txtRecordissuedate);
		txtRecordissuedate.setColumns(10);

	}

}
