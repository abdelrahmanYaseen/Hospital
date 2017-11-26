package hospital;

import java.util.Date;

public class Senior extends Doctor {
	
	private String employmentHistory;
	
	public Senior(String ssn, String name, String gender, String insuranceType, Date dateOfBirth,
			int availableLeaveDays, float salary, String departmentWorksIn, String specialization,String employmentHistory) {
		super(ssn, name, gender, insuranceType, dateOfBirth, availableLeaveDays, salary, departmentWorksIn, specialization);
		
		this.setEmploymentHistory(employmentHistory);
	}

	public String getEmploymentHistory() {
		return employmentHistory;
	}

	public void setEmploymentHistory(String employmentHistory) {
		this.employmentHistory = employmentHistory;
	}



}
