package hospital;

import java.util.Date;

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

}
