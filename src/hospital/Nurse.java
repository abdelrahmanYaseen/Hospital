package hospital;

import java.util.Date;

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
