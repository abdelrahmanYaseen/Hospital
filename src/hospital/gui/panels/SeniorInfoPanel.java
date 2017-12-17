package gui.panels;

import javax.script.ScriptContext;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import hospital.HospitalManagementApplication;
import hospital.Person;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollBar;

public class SeniorInfoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblEmploymentHistory;
	private JTextPane txtpnEmploymentHistory;
	private DefaultListModel<String> listModel;
	private JList<String> list;
	private JLabel lblNurses;
	
	public JLabel getLblEmploymentHistory() {
		return lblEmploymentHistory;
	}

	public void setLblEmploymentHistory(JLabel lblEmploymentHistory) {
		this.lblEmploymentHistory = lblEmploymentHistory;
	}

	public JTextPane getTxtpnEmploymentHistory() {
		return txtpnEmploymentHistory;
	}

	public void setTxtpnEmploymentHistory(JTextPane txtpnEmploymentHistory) {
		this.txtpnEmploymentHistory = txtpnEmploymentHistory;
	}

	public DefaultListModel<String> getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel<String> listModel) {
		this.listModel = listModel;
	}

	public JList<String> getList() {
		return list;
	}

	public void setList(JList<String> list) {
		this.list = list;
	}

	public JLabel getLblNurses() {
		return lblNurses;
	}

	public void setLblNurses(JLabel lblNurses) {
		this.lblNurses = lblNurses;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Create the panel.
	 */
	
	public boolean isFilled(){
		if(txtpnEmploymentHistory.getText().equals("")){
			return false;
		}
		return true;
	}
	
	public SeniorInfoPanel(HospitalManagementApplication H) {
		setLayout(null);
		
		lblEmploymentHistory= new JLabel("Employment History  :");
		lblEmploymentHistory.setBounds(25, 67, 138, 16);
		add(lblEmploymentHistory);
		
		txtpnEmploymentHistory = new JTextPane();
		txtpnEmploymentHistory.setBounds(175, 13, 131, 117);
		add(txtpnEmploymentHistory);
		
		listModel = new DefaultListModel<String>();
		
		for (Person nurse : H.getNurses()) {
			listModel.addElement(nurse.getSsn());
		}
		
		list = new JList<String>(listModel);
		
		lblNurses = new JLabel("Nurses :");
		lblNurses.setBounds(25, 213, 56, 16);
		add(lblNurses);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(175, 168, 131, 117);
		scrollPane.setViewportView(list);
		add(scrollPane);

		
	}
}
