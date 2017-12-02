package hospital;

import java.util.Date;
import java.util.Scanner;

public class Nurse extends Person implements Employee {
	
	private float salary;
	private int availableLeaveDays;
	private String departmentWorksIn;

	public Nurse(String ssn, String name, String gender, Date dateOfBirth, String insuranceType,float salary,int availableLeaveDays,String departmentWorksIn) {
		
		super(ssn, name, gender, dateOfBirth, insuranceType);
		this.salary=salary;
		this.availableLeaveDays=availableLeaveDays;
		this.departmentWorksIn=departmentWorksIn;
		
	}
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
		}while(h.isExist(ssn, "Nurse")!=null);
		this.ssn=ssn;
		
		System.out.print("Enter in which department does this nurse work : ");
		this.departmentWorksIn = input.nextLine();
		this.availableLeaveDays=20;
		this.salary = 100;
		
		System.out.print("Enter the salary of this nurse : ");
		this.salary = Float.parseFloat(input.nextLine());
	}
	
	@Override
	public String toString() {
		return "----------------- Nurse -----------------\n" + super.toString() 
		+ "\n Availabe leave days : " + availableLeaveDays +
		"\n Salary :" + salary + "\n Department :" + 
		departmentWorksIn;
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
