package gui.panels;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import hospital.HospitalManagementApplication;
import hospital.Person;
import hospital.Senior;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class JuniorInfoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtStartDate;
	private JTextField txtEndDate;
	private DefaultListModel<String> listModel;
	private JList<String> list;
	private JLabel lblSupervisingDoctor;
	private JScrollPane scrollPane;
	
	public boolean isFilled(){
		if(txtStartDate.getText().equals("")||txtEndDate.getText().equals(""))
			return false;
		return true;
	}

	/**
	 * @return the txtStartDate
	 */
	public JTextField getTxtStartDate() {
		return txtStartDate;
	}

	/**
	 * @param txtStartDate the txtStartDate to set
	 */
	public void setTxtStartDate(JTextField txtStartDate) {
		this.txtStartDate = txtStartDate;
	}

	/**
	 * @return the txtEndDate
	 */
	public JTextField getTxtEndDate() {
		return txtEndDate;
	}

	/**
	 * @param txtEndDate the txtEndDate to set
	 */
	public void setTxtEndDate(JTextField txtEndDate) {
		this.txtEndDate = txtEndDate;
	}

	/**
	 * Create the panel.
	 */
	public JuniorInfoPanel(HospitalManagementApplication H) {
		setLayout(null);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(27, 29, 73, 16);
		add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(27, 73, 56, 16);
		add(lblEndDate);
		
		txtStartDate = new JTextField();
		txtStartDate.setBounds(173, 26, 116, 22);
		add(txtStartDate);
		txtStartDate.setColumns(10);
		
		txtEndDate = new JTextField();
		txtEndDate.setBounds(173, 70, 116, 22);
		add(txtEndDate);
		txtEndDate.setColumns(10);
		

		listModel = new DefaultListModel<String>();
		
		for (Person doctor : H.getDoctors()) {
			if(doctor instanceof Senior)
				listModel.addElement(doctor.getSsn());
		}
		
		list = new JList<String>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		if(!listModel.isEmpty())
			list.setSelectedIndex(0);
		
		list.setBounds(173, 105, 116, 303);
//		add(list);
		
		lblSupervisingDoctor = new JLabel("Supervising doctor ssn");
		lblSupervisingDoctor.setBounds(27, 102, 139, 30);
		add(lblSupervisingDoctor);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(173, 107, 116, 130);
		scrollPane.setViewportView(list);
		add(scrollPane);

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
}
