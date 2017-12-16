package hospital;

import java.util.Date;
import java.util.Scanner;

/**
 * This class represents a Junior doctor, who has to be supervised by a senior doctor.
 * 
 * @author yaseen
 *
 */
public class Junior extends Doctor {

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the expectedEndDate
	 */
	public Date getExpectedEndDate() {
		return expectedEndDate;
	}
	/**
	 * @param expectedEndDate the expectedEndDate to set
	 */
	public void setExpectedEndDate(Date expectedEndDate) {
		this.expectedEndDate = expectedEndDate;
	}
	/**
	 * @return the supervisorSSN
	 */
	public String getSupervisorSSN() {
		return supervisorSSN;
	}
	/**
	 * @param supervisorSSN the supervisorSSN to set
	 */
	public void setSupervisorSSN(String supervisorSSN) {
		this.supervisorSSN = supervisorSSN;
	}

	/**
	 * The start date of training
	 */
	private Date startDate;
	/**
	 * The expected end date of the training
	 */
	private Date expectedEndDate;
	/**
	 * The ssn of the supervising senior doctor
	 */
	private String supervisorSSN;
	
	/**
	 * This constructor accepts the necessary information for creating a junior object as arguments.
	 * @param ssn
	 * @param name
	 * @param gender
	 * @param insuranceType
	 * @param dateOfBirth
	 * @param availableLeaveDays
	 * @param salary
	 * @param departmentWorksIn
	 * @param specialization
	 * @param startDate
	 * @param expectedEndDate
	 * @param superviserSSN
	 */
	public Junior(String ssn, String name, String gender,String insuranceType, Date dateOfBirth,int availableLeaveDays,float salary, String departmentWorksIn, String specialization,Date startDate, Date expectedEndDate, String superviserSSN) {
		super(ssn, name, gender, insuranceType, dateOfBirth,availableLeaveDays,salary,departmentWorksIn,specialization);
		this.supervisorSSN=superviserSSN;
		this.expectedEndDate=expectedEndDate;
		this.startDate=startDate;
	}
	/**
	 * This constructor accepts a Doctor object which has the Doctor general information
	 * in addition to the extra info neeeded for the Junior.
	 * @param a Doctor
	 * @param startDate
	 * @param expectedEndDate
	 * @param superviserSSN
	 */
	public Junior(Doctor a,Date startDate, Date expectedEndDate, String superviserSSN) {
		super(a.ssn, a.name, a.gender, a.insuranceType, a.dateOfBirth, a.annualLeaveLeft(), a.getSalary(), a.getDepartmentWorksIn(), a.getSpecialization());
		this.supervisorSSN=superviserSSN;
		this.expectedEndDate=expectedEndDate;
		this.startDate=startDate;
	}
	/**
	 * This constructor accepts a Doctor object which has the Doctor general information
	 * and asks the user for the rest of the information
	 * @param a Doctor
	 * @param h Hospital
	 */
	public Junior(Doctor a,HospitalManagementApplication h) {
		super(a.ssn, a.name, a.gender, a.insuranceType, a.dateOfBirth, a.annualLeaveLeft(), a.getSalary(), a.getDepartmentWorksIn(), a.getSpecialization());
		
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
