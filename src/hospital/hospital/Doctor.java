package hospital;

import java.util.Date;
import java.util.Scanner;

/**
 * This class represents the doctors who work in the hospital
 *  @author yaseen
 *
 */
public class Doctor extends Person implements Employee{

	/**
	 * Represents the number of days available for the Employee to leave
	 */
	private int availableLeaveDays;
	/**
	 * Represents the salary of the employee
	 */
	private float salary;
	/**
	 * Represents the department that the employee works in
	 */
	private String departmentWorksIn;
	/**
	 * Represents the specialization of the employee
	 */
	private String specialization;
	
	/**
	 * @param availableLeaveDays the availableLeaveDays to set
	 */
	public void setAvailableLeaveDays(int availableLeaveDays) {
		this.availableLeaveDays = availableLeaveDays;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	/**
	 * A constructor which accepts all the required fields as arguments
	 * @param ssn
	 * @param name
	 * @param gender
	 * @param insuranceType
	 * @param dateOfBirth
	 * @param availableLeaveDays
	 * @param salary
	 * @param departmentWorksIn
	 * @param specialization
	 */
	public Doctor(String ssn,String name, String gender,String insuranceType, Date dateOfBirth,int availableLeaveDays,float salary, String departmentWorksIn, String specialization) {
		super(ssn,name,gender,dateOfBirth,insuranceType);
		
		this.availableLeaveDays=availableLeaveDays;
		this.salary=salary;
		this.departmentWorksIn=departmentWorksIn;
		this.specialization=specialization;
	}
	/**
	 * A constructor which asks the user to enter the required fields.
	 * @param h
	 */
	public Doctor(HospitalManagementApplication h) {
		super();
		Scanner input = new Scanner(System.in);
		String ssn;
		boolean temp=true;//used to give error message if the ssn is already in use
		do {
			if(!temp) {
				System.out.println("The SSN is already in use !");
			}
			System.out.print("Enter the SSN of the doctor : ");
			ssn = input.nextLine();
			temp=false;
		}while(!(h.isExist(ssn, "Doctor")==null && h.isExist(ssn, "Nurse")==null));
		this.ssn=ssn;
		System.out.print("Enter in which department does this doctor work : ");
		this.departmentWorksIn = input.nextLine();
		System.out.print("Enter the specialization of the doctor : ");
		this.specialization = input.nextLine();
		this.availableLeaveDays=25;
		
	}
	@Override
	public String toString() {
		
		return "----------------- Doctor-----------------\n" +
		super.toString() + "\n Availabe leave days : "+ 
		availableLeaveDays +"\n Salary :" + salary + 
		"\n Department :" + departmentWorksIn +
		"\n Specialization :"+specialization;
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
		else
			System.out.println("Not available");
	}
	/**
	 * @return the salary
	 */
	public float getSalary() {
		return salary;
	}
	/**
	 * @return the departmentWorksIn
	 */
	public String getDepartmentWorksIn() {
		return departmentWorksIn;
	}
	/**
	 * @return the specialization
	 */
	public String getSpecialization() {
		return specialization;
	}
	
	
}
