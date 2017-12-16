package hospital;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * This class represents a Nurse
 * @author yaseen
 *
 */
public class Nurse extends Person implements Employee {
	
	/**
	 * @return the salary
	 */
	public float getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(float salary) {
		this.salary = salary;
	}

	/**
	 * @return the availableLeaveDays
	 */
	public int getAvailableLeaveDays() {
		return availableLeaveDays;
	}

	/**
	 * @param availableLeaveDays the availableLeaveDays to set
	 */
	public void setAvailableLeaveDays(int availableLeaveDays) {
		this.availableLeaveDays = availableLeaveDays;
	}

	/**
	 * @return the departmentWorksIn
	 */
	public String getDepartmentWorksIn() {
		return departmentWorksIn;
	}

	/**
	 * @param departmentWorksIn the departmentWorksIn to set
	 */
	public void setDepartmentWorksIn(String departmentWorksIn) {
		this.departmentWorksIn = departmentWorksIn;
	}

	/**
	 * @return the doctorsWorkingFor
	 */
	public ArrayList<String> getDoctorsWorkingFor() {
		return doctorsWorkingFor;
	}

	/**
	 * @param doctorsWorkingFor the doctorsWorkingFor to set
	 */
	public void setDoctorsWorkingFor(ArrayList<String> doctorsWorkingFor) {
		this.doctorsWorkingFor = doctorsWorkingFor;
	}

	/**
	 * the salary of the nurse
	 */
	private float salary;
	/**
	 * the available leave days of the nurse
	 */
	private int availableLeaveDays;
	/**
	 * the department that the nurse works in
	 */
	private String departmentWorksIn;
	/**
	 * the list of doctors that the nurse work for
	 */
	private ArrayList<String> doctorsWorkingFor;
	/**
	 * This constuctor accepts the necessary information for creating a nurse as arguments
	 * @param ssn
	 * @param name
	 * @param gender
	 * @param dateOfBirth
	 * @param insuranceType
	 * @param salary
	 * @param availableLeaveDays
	 * @param departmentWorksIn
	 * @param doctorsWorkingFor
	 */
	public Nurse(String ssn, String name, String gender, Date dateOfBirth, String insuranceType,float salary,int availableLeaveDays,String departmentWorksIn,ArrayList<String> doctorsWorkingFor) {
		
		super(ssn, name, gender, dateOfBirth, insuranceType);
		this.salary=salary;
		this.availableLeaveDays=availableLeaveDays;
		this.departmentWorksIn=departmentWorksIn;
		this.doctorsWorkingFor=doctorsWorkingFor;
	}
	
	/**
	 * This constructor asks the user to enter the necessary information for creating a nurse object.
	 * @param h
	 */
	public Nurse(HospitalManagementApplication h) {
		super();
		Scanner input = new Scanner(System.in);
		String ssn;
		boolean temp=true;//used to give error message if the ssn is already in use
		do {
			if(!temp) {
				System.out.println("The SSN is already in use !");
			}
			System.out.print("Enter the SSN of the nurse : ");
			ssn = input.nextLine();
			temp=false;
		}while(h.isExist(ssn, "Nurse")!=null && h.isExist(ssn, "Doctor")!=null);
		this.ssn=ssn;
		
		System.out.print("Enter in which department does this nurse work : ");
		this.departmentWorksIn = input.nextLine();
		this.availableLeaveDays=20;
		this.salary = 100;
		
		System.out.print("Enter the salary of this nurse : ");
		this.salary = Util.requestSalaryWithRange(3000, 5000);
		
		System.out.println("Enter the 1 to start adding the doctors that this nurse is working for (-1 to skip) :");
		String doctorSsn;
		doctorsWorkingFor= new ArrayList<String>();
		while(Integer.parseInt(doctorSsn=input.nextLine())!=-1) {
			System.out.println("Enter the ssn of the doctor:");
			if((ssn=Util.requestSeniorSsn(h))!=null) {
				this.doctorsWorkingFor.add(doctorSsn);
				Senior s= (Senior)h.isExist(doctorSsn, "Senior");
				s.addNurse(this.ssn);
			}
			System.out.println("Added.\nEnter another ssn to add, or -1 to finish");
		}
	}
	
	/**
	 * This method is used to add a doctor to the list of doctors that the nurse works for
	 * @param doctorSsn
	 */
	public void workFor(String doctorSsn) {
		doctorsWorkingFor.add(doctorSsn);
	}
	@Override
	public String toString() {
		return "\n----------------- Nurse -----------------\n" + super.toString() 
		+ "\n Availabe leave days : " + availableLeaveDays +
		"\n Salary :" + salary + "\n Department :" + 
		departmentWorksIn+"\n Doctors working for :"+doctorsWorkingFor;
	}
	
	
	@Override
	public float salary() {
		
		return salary;
	}

	@Override
	public int annualLeaveLeft() {
		return availableLeaveDays;
	}

	@Override
	public void goAnnualLeave(int numberOfDays) {
		if(availableLeaveDays-numberOfDays > 0)
			availableLeaveDays-=numberOfDays;

	}

}
