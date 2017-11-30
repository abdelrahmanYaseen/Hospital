package hospital;

import java.util.Date;
import java.util.Scanner;

public class Senior extends Doctor {
	
	private String employmentHistory;
	
	public Senior(String ssn, String name, String gender, String insuranceType, Date dateOfBirth,
			int availableLeaveDays, float salary, String departmentWorksIn, String specialization,String employmentHistory) {
		super(ssn, name, gender, insuranceType, dateOfBirth, availableLeaveDays, salary, departmentWorksIn, specialization);
		
		this.setEmploymentHistory(employmentHistory);
	}
	public Senior(Doctor a,String employmentHistory) {
		super(a.ssn, a.name, a.gender, a.insuranceType, a.dateOfBirth, a.getAvailableLeaveDays(), a.getSalary(), a.getDepartmentWorksIn(), a.getSpecialization());
		this.employmentHistory=employmentHistory;
	}
	public Senior(Doctor a) {
		super(a.ssn, a.name, a.gender, a.insuranceType, a.dateOfBirth, a.getAvailableLeaveDays(), a.getSalary(), a.getDepartmentWorksIn(), a.getSpecialization());
		System.out.println("Enter the employment history :");
		Scanner input = new Scanner(System.in);
		this.employmentHistory=input.nextLine();
	}

	public String getEmploymentHistory() {
		return employmentHistory;
	}

	public void setEmploymentHistory(String employmentHistory) {
		this.employmentHistory = employmentHistory;
	}
	
	@Override
	public String toString() {
		return "\n----------------- Senior -----------------\n"+super.toString()+"\n Employment History:"+this.employmentHistory;
	}



}
