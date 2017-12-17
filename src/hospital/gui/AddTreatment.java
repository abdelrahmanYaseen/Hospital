package gui;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.panels.TreatmentPanel;
import hospital.HospitalManagementApplication;
import hospital.Treatment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddTreatment extends JFrame {

	private JPanel contentPane;
	private boolean validInput;


	/**
	 * Create the frame.
	 */
	public AddTreatment(HospitalManagementApplication H, ArrayList<Treatment> treatments,String insuranceType) {
		setBounds(100, 100, 618, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TreatmentPanel treatmentPanel = new TreatmentPanel(H);
		treatmentPanel.setBounds(0, 0, 609, 409);
		contentPane.add(treatmentPanel);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(treatmentPanel.isFilled()){
					String description = treatmentPanel.getTxtrDescription().getText();
					String details = treatmentPanel.getTxtrDetails().getText();
					String medication = treatmentPanel.getTxtrMedication().getText();
					String superviserSsn = treatmentPanel.getList().getSelectedValue();
					String type;
					Float cost=(float) 0;
					
					if(treatmentPanel.getRdbtnMust().isSelected()){
						type = "Must";
					} else {
						type = "Optional";
					}
					try{
						cost = Float.parseFloat(treatmentPanel.getTxtCost().getText());
						validInput=true;
					} catch (Exception w) {
						JOptionPane.showMessageDialog(null, "The cost must be number ! ");
						validInput=false;
					}
					if(validInput){
						Treatment treatment = new Treatment(details, description, medication, superviserSsn, cost, type, insuranceType);
						treatments.add(treatment);
						JOptionPane.showMessageDialog(null, "Treatment number " +treatments.size()+" is Added successfully");
						dispose();
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Make sure that all the information are filled !");
				}
			}
		});
		btnAdd.setBounds(253, 465, 97, 25);
		contentPane.add(btnAdd);
	}
}
