package gui.panels;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class EmployeeInfoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textAvailableLeaveDays;
	private JTextField txtSalary;
	private JTextField txtDepartment;
	private JTextField txtSpecialization;
	
	private JLabel lblSpecialization;

	/**
	 * @return the lblSpecialization
	 */
	public JLabel getLblSpecialization() {
		return lblSpecialization;
	}
	/**
	 * @param lblSpecialization the lblSpecialization to set
	 */
	public void setLblSpecialization(JLabel lblSpecialization) {
		this.lblSpecialization = lblSpecialization;
	}
	/**
	 * Create the panel.
	 */
	
	
	public boolean isFilled(){
		if(textAvailableLeaveDays.getText().equals("")||txtSalary.getText().equals("")||txtDepartment.getText().equals("")||txtSpecialization.getText().equals(""))
			return false;
		return true;
	}
	public EmployeeInfoPanel() {
		setLayout(null);
		
		JLabel lblAvailableleavedays = new JLabel("Available Leave Days");
		lblAvailableleavedays.setBounds(12, 32, 143, 16);
		add(lblAvailableleavedays);
		
		textAvailableLeaveDays = new JTextField();
		textAvailableLeaveDays.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textAvailableLeaveDays.setEditable(false);
		textAvailableLeaveDays.setBounds(156, 29, 116, 22);
		add(textAvailableLeaveDays);
		textAvailableLeaveDays.setColumns(10);
		
		JLabel lblSalary = new JLabel("Salary ");
		lblSalary.setBounds(12, 73, 56, 16);
		add(lblSalary);
		
		txtSalary = new JTextField();
		txtSalary.setBounds(156, 70, 116, 22);
		add(txtSalary);
		txtSalary.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(12, 115, 96, 16);
		add(lblDepartment);
		
		txtDepartment = new JTextField();
		txtDepartment.setBounds(156, 112, 116, 22);
		add(txtDepartment);
		txtDepartment.setColumns(10);
		
		lblSpecialization = new JLabel("Specialization");
		lblSpecialization.setBounds(12, 160, 96, 16);
		add(lblSpecialization);
		
		txtSpecialization = new JTextField();
		txtSpecialization.setBounds(156, 157, 116, 22);
		add(txtSpecialization);
		txtSpecialization.setColumns(10);

	}
	/**
	 * @return the textAvailableLeaveDays
	 */
	public JTextField getTextAvailableLeaveDays() {
		return textAvailableLeaveDays;
	}
	/**
	 * @param textAvailableLeaveDays the textAvailableLeaveDays to set
	 */
	public void setTextAvailableLeaveDays(JTextField textAvailableLeaveDays) {
		this.textAvailableLeaveDays = textAvailableLeaveDays;
	}
	/**
	 * @return the txtSalary
	 */
	public JTextField getTxtSalary() {
		return txtSalary;
	}
	/**
	 * @param txtSalary the txtSalary to set
	 */
	public void setTxtSalary(JTextField txtSalary) {
		this.txtSalary = txtSalary;
	}
	/**
	 * @return the txtDepartment
	 */
	public JTextField getTxtDepartment() {
		return txtDepartment;
	}
	/**
	 * @param txtDepartment the txtDepartment to set
	 */
	public void setTxtDepartment(JTextField txtDepartment) {
		this.txtDepartment = txtDepartment;
	}
	/**
	 * @return the txtSpecialization
	 */
	public JTextField getTxtSpecialization() {
		return txtSpecialization;
	}
	/**
	 * @param txtSpecialization the txtSpecialization to set
	 */
	public void setTxtSpecialization(JTextField txtSpecialization) {
		this.txtSpecialization = txtSpecialization;
	}
	
}
