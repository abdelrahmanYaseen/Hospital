package gui;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hospital.HospitalManagementApplication;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 815974787408727741L;
	private JPanel contentPane;
	private final JButton bt_add = new JButton("Add");
	private final JButton btn_remove = new JButton("Remove");
	private final JButton btn_DisplayDetails = new JButton("Display Details");
	private final JButton btn_DisplayPatientTreatment = new JButton("Display Patient Treatment");
	private final JButton btn_Promote = new JButton("Promote a junior doctor");
	private final JButton btn_DisplayPatientDepartment = new JButton("Display patient department");
	private final JButton btn_GetAvailableLeaveDays = new JButton("Get available leave days");
	private final JButton btn_RetrieveTheLatestMedicalRecord = new JButton("Retrieve the latest medical record of patient");
	private final JButton btn_RetrieveAllTreatments = new JButton("Retrieve all the treatments");
	private final JButton btn_GetTreatmentsIncome = new JButton("Get treatments income");
	private final JButton btn_GetBudgetStatus = new JButton("Get budget status");
	private final JButton btn_ListAll = new JButton("List All");
	private HospitalManagementApplication H = new HospitalManagementApplication();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("a");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		bt_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddMenu addMain = new AddMenu(H);
				addMain.setVisible(true);
			}
		});
		bt_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(bt_add);
		panel.add(btn_remove);
		panel.add(btn_DisplayDetails);
		panel.add(btn_DisplayPatientTreatment);
		
		panel.add(btn_RetrieveTheLatestMedicalRecord);
		btn_Promote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		panel.add(btn_Promote);
		
		panel.add(btn_RetrieveAllTreatments);
		
		panel.add(btn_DisplayPatientDepartment);
		
		panel.add(btn_GetTreatmentsIncome);
		btn_GetAvailableLeaveDays.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		panel.add(btn_GetAvailableLeaveDays);
		btn_ListAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ListAll listAll = new ListAll(H);
				listAll.setVisible(true);
			}
		});
		btn_ListAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		panel.add(btn_ListAll);
		
		panel.add(btn_GetBudgetStatus);
	}

}
