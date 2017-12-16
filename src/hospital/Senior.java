package hospital;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * This class represents a Senior doctor, which can do the treatments and have nurses and supervise Junior doctors
 * @author yaseen
 *
 */
public class Senior extends Doctor {
	
	/**
	 * @return the nurses
	 */
	public ArrayList<String> getNurses() {
		return nurses;
	}
	/**
	 * @param nurses the nurses to set
	 */
	public void setNurses(ArrayList<String> nurses) {
		this.nurses = nurses;
	}

	/**
	 * The employment histore of the senior doctor.
	 */
	private String employmentHistory;
	/**
	 * a List of nurses working for this doctor.
	 */
	private ArrayList<String> nurses;
	
	/**
	 * 
	 * @param ssn
	 * @param name
	 * @param gender
	 * @param insuranceType
	 * @param dateOfBirth
	 * @param availableLeaveDays
	 * @param salary
	 * @param departmentWorksIn
	 * @param specialization
	 * @param employmentHistory
	 * @param nurses
	 */
	public Senior(String ssn, String name, String gender, String insuranceType, Date dateOfBirth,
			int availableLeaveDays, float salary, String departmentWorksIn, String specialization,String employmentHistory, ArrayList<String> nurses) {
		super(ssn, name, gender, insuranceType, dateOfBirth, availableLeaveDays, salary, departmentWorksIn, specialization);
		
		this.setEmploymentHistory(employmentHistory);
		this.nurses=nurses;
	}
	/**
	 * This constructor accepts a Doctor object which has the Doctor general information
	 * in addition to the extra info needed for the Senior.
	 * @param a
	 * @param employmentHistory
	 * @param nurses
	 */
	public Senior(Doctor a,String employmentHistory, ArrayList<String> nurses) {
		super(a.ssn, a.name, a.gender, a.insuranceType, a.dateOfBirth, a.annualLeaveLeft(), a.getSalary(), a.getDepartmentWorksIn(), a.getSpecialization());
		this.employmentHistory=employmentHistory;
		this.nurses=nurses;
	}
	/**
	 * This constructor accepts a Doctor object which has the Doctor general information
	 * It asks the user to enter  the extra info needed for the Senior.
	 * @param a
	 * @param h
	 */
	public Senior(Doctor a,HospitalManagementApplication h) {
		super(a.ssn, a.name, a.gender, a.insuranceType, a.dateOfBirth, a.annualLeaveLeft(), a.getSalary(), a.getDepartmentWorksIn(), a.getSpecialization());
		System.out.println("Enter the employment history :");
		Scanner input = new Scanner(System.in);
		this.employmentHistory=input.nextLine();
		System.out.println("Enter 1 to start adding the nurses that are working for this doctor (-1 to skip) :");
		String nurseSsn;
		nurses= new ArrayList<String>();
		while(Integer.parseInt(nurseSsn=input.nextLine())!=-1) {
			System.out.println("Enter the SSN of the nurse :");
			if((nurseSsn=Util.requestNurseSsn(h))!=null) {
				this.nurses.add(nurseSsn);
				Nurse n = (Nurse)h.isExist(nurseSsn, "Nurse");
				n.workFor(this.ssn);
			}
			System.out.println("Added.\n Enter 1 to add one more, or -1 to finish");
		}
	}

	/**
	 * This method is used to add a nurse to the list of nurses
	 * @param nurseSsn
	 */
	public void addNurse(String nurseSsn) {
		nurses.add(nurseSsn);
	}
	/**
	 * A getter for the employment history.
	 * @return
	 */
	public String getEmploymentHistory() {
		return employmentHistory;
	}
	/**
	 * A setter for the employment history.
	 * @param employmentHistory
	 */
	public void setEmploymentHistory(String employmentHistory) {
		this.employmentHistory = employmentHistory;
	}
	
	@Override
	public String toString() {
		return "\n----------------- Senior -----------------\n"+super.toString()+"\n Employment History:"+this.employmentHistory+"\n Nurses SSNs :"+nurses;
	}



}
