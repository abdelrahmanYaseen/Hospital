package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.panels.TreatmentPanel;
import hospital.HospitalManagementApplication;
import hospital.Treatment;
import java.awt.Dialog.ModalityType;
import java.awt.Window.Type;

public class AddTreatmentDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private boolean validInput;
	public AddTreatmentDialog(HospitalManagementApplication H, ArrayList<Treatment> treatments,String insuranceType) {
		setType(Type.POPUP);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 618, 594);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		TreatmentPanel treatmentPanel = new TreatmentPanel(H);
		treatmentPanel.setBounds(0, 0, 609, 409);
		contentPanel.add(treatmentPanel);
		
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
		contentPanel.add(btnAdd);
	}

}
