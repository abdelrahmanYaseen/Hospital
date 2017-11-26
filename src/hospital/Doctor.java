package hospital;

import java.util.Date;

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
