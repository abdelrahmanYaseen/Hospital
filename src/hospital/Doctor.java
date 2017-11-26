package hospital;

import java.util.Date;
import java.util.Scanner;

/**
 * This class represents the doctors who work in the hospital
 *  @author yaseen
 *
 */
public class Doctor extends Person implements Employee{

	
	private int availableLeaveDays;
	private float salary;
	
	private String departmentWorksIn;
	private String specialization;
	

	public Doctor(String ssn,String name, String gender,String insuranceType, Date dateOfBirth,int availableLeaveDays,float salary, String departmentWorksIn, String specialization) {
		super(ssn,name,gender,dateOfBirth,insuranceType);
		
		this.availableLeaveDays=availableLeaveDays;
		this.salary=salary;
		this.departmentWorksIn=departmentWorksIn;
		this.specialization=specialization;
	}
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
		}while(h.isExist(ssn, "Doctor"));
		this.ssn=ssn;
		System.out.print("Enter in which department does this doctor work : ");
		this.departmentWorksIn = input.nextLine();
		System.out.print("Enter the specialization of the doctor : ");
		this.specialization = input.nextLine();
		this.availableLeaveDays=25;
		this.salary = 100;
	}
	@Override
	public String toString() {
		
		return "----------------- Doctor-----------------\n" +
		super.toString() + "\nAvailabe leave days : "+ 
		availableLeaveDays +"\n Salary :" + salary + 
		"\n Department :" + departmentWorksIn +
		"\nSpecialization :"+specialization;
	}

	@Override
	public float salary() {

		return salary;
	}

	@Override
	public int annualLeaveLeft() {
		// TODO Auto-generated method stub
		return availableLeaveDays;
	}

	@Override
	public void goAnnualLeave(int numberOfDays) {
		if(availableLeaveDays-numberOfDays > 0)
			availableLeaveDays-=numberOfDays;
	}
	
	
}
