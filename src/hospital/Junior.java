package hospital;

import java.util.Date;
import java.util.Scanner;

public class Junior extends Doctor {

	private Date startDate;
	private Date expectedEndDate;
	private String supervisorSSN;
	//String ssn,String name, String gender,String insuranceType, Date dateOfBirth,int availableLeaveDays,float salary, String departmentWorksIn, String specialization
	public Junior(String ssn, String name, String gender,String insuranceType, Date dateOfBirth,int availableLeaveDays,float salary, String departmentWorksIn, String specialization,Date startDate, Date expectedEndDate, String superviserSSN) {
		super(ssn, name, gender, insuranceType, dateOfBirth,availableLeaveDays,salary,departmentWorksIn,specialization);
		this.supervisorSSN=superviserSSN;
		this.expectedEndDate=expectedEndDate;
		this.startDate=startDate;
	}
	public Junior(Doctor a,Date startDate, Date expectedEndDate, String superviserSSN) {
		super(a.ssn, a.name, a.gender, a.insuranceType, a.dateOfBirth, a.getAvailableLeaveDays(), a.getSalary(), a.getDepartmentWorksIn(), a.getSpecialization());
		this.supervisorSSN=superviserSSN;
		this.expectedEndDate=expectedEndDate;
		this.startDate=startDate;
	}
	public Junior(Doctor a,HospitalManagementApplication h) {
		super(a.ssn, a.name, a.gender, a.insuranceType, a.dateOfBirth, a.getAvailableLeaveDays(), a.getSalary(), a.getDepartmentWorksIn(), a.getSpecialization());
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the ssn of the supervising doctor : ");
		this.supervisorSSN=Util.requestDoctorSsn(h);
		System.out.println("Enter the start date (dd-mm-yyy): ");
		this.startDate=Util.requestDate();
		System.out.println("Enter the expected end date (dd-mm-yyy): ");
		this.expectedEndDate=Util.requestDate();
	}
	
	@Override
	public String toString() {
		return "\n----------------- Junior -----------------\n"+super.toString()+"\n Supervisor SSN :"+this.supervisorSSN+"\n Start date :"+this.startDate+"\n Expected end date:"+this.expectedEndDate+"\n **************";
	}

}
