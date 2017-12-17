package gui.panels;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PersonalInfoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	public JTextField getTxtName() {
		return txtName;
	}

	public void setTxtName(JTextField txtName) {
		this.txtName = txtName;
	}

	public JTextField getTxtSsn() {
		return txtSsn;
	}

	public void setTxtSsn(JTextField txtSsn) {
		this.txtSsn = txtSsn;
	}

	public JTextField getTxtDate() {
		return txtDate;
	}

	public void setTxtDate(JTextField txtDate) {
		this.txtDate = txtDate;
	}

	private JTextField txtSsn;
	private JTextField txtDate;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnFull;
	private JRadioButton rdbtnPartial;
	private JRadioButton rdbtnNotCovered;
	
	public boolean isFilled(){
		if(txtName.getText().equals("") || txtSsn.getText().equals("") || txtDate.getText().equals("") )
			return false;
		return true;
	}

	/**
	 * Create the panel.
	 */
	public PersonalInfoPanel() {
		setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(12, 0, 70, 30);
		add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(82, 0, 168, 30);
		txtName.setToolTipText("Enter the name");
		add(txtName);
		txtName.setColumns(5);
		
		JLabel lblSsn = new JLabel("SSN");
		lblSsn.setBounds(12, 43, 64, 30);
		add(lblSsn);
		
		txtSsn = new JTextField();
		txtSsn.setBounds(82, 43, 168, 30);
		txtName.setToolTipText("Enter the SSN");
		add(txtSsn);
		txtSsn.setColumns(5);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(12, 87, 70, 15);
		add(lblGender);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setSelected(true);
		rdbtnMale.setBounds(183, 82, 64, 25);
		add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(82, 82, 90, 25);
		add(rdbtnFemale);
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(rdbtnMale);
		genderGroup.add(rdbtnFemale);
		
		JLabel lblDate = new JLabel("Date (dd-mm-yyyy)");
		lblDate.setBounds(12, 121, 116, 16);
		add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setBounds(134, 118, 116, 22);
		add(txtDate);
		txtDate.setColumns(10);
		
		JLabel lblInsuranceType = new JLabel("Insurance type");
		lblInsuranceType.setBounds(12, 168, 90, 16);
		add(lblInsuranceType);
		
		rdbtnFull = new JRadioButton("Full");
		rdbtnFull.setBounds(155, 164, 127, 25);
		add(rdbtnFull);
		
		rdbtnPartial = new JRadioButton("Partial");
		rdbtnPartial.setBounds(155, 201, 127, 25);
		add(rdbtnPartial);
		
		rdbtnNotCovered = new JRadioButton("Not covered");
		rdbtnNotCovered.setSelected(true);
		rdbtnNotCovered.setBounds(155, 242, 127, 25);
		add(rdbtnNotCovered);
		
		ButtonGroup insuranceGroup = new ButtonGroup();
		insuranceGroup.add(rdbtnNotCovered);
		insuranceGroup.add(rdbtnFull);
		insuranceGroup.add(rdbtnPartial);

	}

	/**
	 * @return the rdbtnFull
	 */
	public JRadioButton getRdbtnFull() {
		return rdbtnFull;
	}

	/**
	 * @param rdbtnFull the rdbtnFull to set
	 */
	public void setRdbtnFull(JRadioButton rdbtnFull) {
		this.rdbtnFull = rdbtnFull;
	}

	/**
	 * @return the rdbtnPartial
	 */
	public JRadioButton getRdbtnPartial() {
		return rdbtnPartial;
	}

	/**
	 * @param rdbtnPartial the rdbtnPartial to set
	 */
	public void setRdbtnPartial(JRadioButton rdbtnPartial) {
		this.rdbtnPartial = rdbtnPartial;
	}

	/**
	 * @return the rdbtnNotCovered
	 */
	public JRadioButton getRdbtnNotCovered() {
		return rdbtnNotCovered;
	}

	/**
	 * @param rdbtnNotCovered the rdbtnNotCovered to set
	 */
	public void setRdbtnNotCovered(JRadioButton rdbtnNotCovered) {
		this.rdbtnNotCovered = rdbtnNotCovered;
	}

	/**
	 * @return the rdbtnMale
	 */
	public JRadioButton getRdbtnMale() {
		return rdbtnMale;
	}

	/**
	 * @param rdbtnMale the rdbtnMale to set
	 */
	public void setRdbtnMale(JRadioButton rdbtnMale) {
		this.rdbtnMale = rdbtnMale;
	}

	/**
	 * @return the rdbtnFemale
	 */
	public JRadioButton getRdbtnFemale() {
		return rdbtnFemale;
	}

	/**
	 * @param rdbtnFemale the rdbtnFemale to set
	 */
	public void setRdbtnFemale(JRadioButton rdbtnFemale) {
		this.rdbtnFemale = rdbtnFemale;
	}
}
