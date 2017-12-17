package gui.panels;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

import hospital.HospitalManagementApplication;
import hospital.Person;
import hospital.Senior;

public class TreatmentPanel extends JPanel {
	
	private JTextField txtCost;
	private JTextArea txtrDetails;
	private JTextArea txtrMedication;
	private JTextArea txtrDescription;
	private JRadioButton rdbtnMust;
	private JRadioButton rdbtnOptional;
	private DefaultListModel<String> listModel;
	private JList<String> list;
	
	public boolean isFilled(){
		if(txtCost.getText().equals("") || txtrDescription.getText().equals("") || txtrDetails.getText().equals("") ||txtrMedication.getText().equals("")){
			return false;
		}
		return true;
	}
	/**
	 * Create the panel.
	 * @param treatments 
	 */
	public TreatmentPanel(HospitalManagementApplication H) {
		setLayout(null);
		
		JLabel lblDetails = new JLabel("Details :");
		lblDetails.setBounds(49, 63, 56, 16);
		add(lblDetails);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(353, 63, 79, 16);
		add(lblDescription);
		
		JLabel lblMedication = new JLabel("Medication :");
		lblMedication.setBounds(49, 173, 94, 16);
		add(lblMedication);
		
		JLabel lblSupervisingDoctor = new JLabel("Supervising doctor :");
		lblSupervisingDoctor.setBounds(49, 282, 115, 16);
		add(lblSupervisingDoctor);
		
		JLabel lblCost = new JLabel("Cost :");
		lblCost.setBounds(353, 173, 56, 16);
		add(lblCost);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setBounds(353, 230, 56, 16);
		add(lblType);
		
		txtrDetails = new JTextArea();
		txtrDetails.setLineWrap(true);
		txtrDetails.setBounds(180, 60, 115, 97);
		add(txtrDetails);
		
		txtrMedication = new JTextArea();
		txtrMedication.setLineWrap(true);
		txtrMedication.setBounds(180, 170, 115, 97);
		add(txtrMedication);
		
		txtrDescription = new JTextArea();
		txtrDescription.setLineWrap(true);
		txtrDescription.setBounds(476, 60, 115, 97);
		add(txtrDescription);
		
		txtCost = new JTextField();
		txtCost.setBounds(475, 170, 116, 22);
		add(txtCost);
		txtCost.setColumns(10);
		
		rdbtnMust = new JRadioButton("Must");
		rdbtnMust.setSelected(true);
		rdbtnMust.setBounds(464, 226, 127, 25);
		add(rdbtnMust);
		
		rdbtnOptional = new JRadioButton("Optional");
		rdbtnOptional.setBounds(464, 266, 127, 25);
		add(rdbtnOptional);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnOptional);
		buttonGroup.add(rdbtnMust);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 280, 115, 109);
		add(scrollPane);
		
		
		
		listModel = new DefaultListModel<String>();
		
		for (Person doctor : H.getDoctors()) {
			if(doctor instanceof Senior)
				listModel.addElement(doctor.getSsn());
		}
		
		list = new JList<String>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		if(!listModel.isEmpty())
			list.setSelectedIndex(0);
		scrollPane.setViewportView(list);

	}
	/**
	 * @return the txtCost
	 */
	public JTextField getTxtCost() {
		return txtCost;
	}
	/**
	 * @return the listModel
	 */
	public DefaultListModel<String> getListModel() {
		return listModel;
	}
	/**
	 * @param listModel the listModel to set
	 */
	public void setListModel(DefaultListModel<String> listModel) {
		this.listModel = listModel;
	}
	/**
	 * @return the list
	 */
	public JList<String> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(JList<String> list) {
		this.list = list;
	}
	/**
	 * @param txtCost the txtCost to set
	 */
	public void setTxtCost(JTextField txtCost) {
		this.txtCost = txtCost;
	}
	/**
	 * @return the txtrDetails
	 */
	public JTextArea getTxtrDetails() {
		return txtrDetails;
	}
	/**
	 * @param txtrDetails the txtrDetails to set
	 */
	public void setTxtrDetails(JTextArea txtrDetails) {
		this.txtrDetails = txtrDetails;
	}
	/**
	 * @return the txtrMedication
	 */
	public JTextArea getTxtrMedication() {
		return txtrMedication;
	}
	/**
	 * @param txtrMedication the txtrMedication to set
	 */
	public void setTxtrMedication(JTextArea txtrMedication) {
		this.txtrMedication = txtrMedication;
	}
	/**
	 * @return the txtrDescription
	 */
	public JTextArea getTxtrDescription() {
		return txtrDescription;
	}
	/**
	 * @param txtrDescription the txtrDescription to set
	 */
	public void setTxtrDescription(JTextArea txtrDescription) {
		this.txtrDescription = txtrDescription;
	}
	/**
	 * @return the rdbtnMust
	 */
	public JRadioButton getRdbtnMust() {
		return rdbtnMust;
	}
	/**
	 * @param rdbtnMust the rdbtnMust to set
	 */
	public void setRdbtnMust(JRadioButton rdbtnMust) {
		this.rdbtnMust = rdbtnMust;
	}
	/**
	 * @return the rdbtnOptional
	 */
	public JRadioButton getRdbtnOptional() {
		return rdbtnOptional;
	}
	/**
	 * @param rdbtnOptional the rdbtnOptional to set
	 */
	public void setRdbtnOptional(JRadioButton rdbtnOptional) {
		this.rdbtnOptional = rdbtnOptional;
	}

}
