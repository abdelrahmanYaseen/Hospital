package hospital;

import java.util.Date;

public abstract class Person {
	
	private String ssn; 
	private String name; 
	private String gender; 
	private Date dateOfBirth; 
	private String insuranceType;
	public Person(String ssn,String name, String gender, Date dateOfBirth, String insuranceType) {
		this.ssn=ssn;
		this.name=name;
		this.gender=gender;
		this.dateOfBirth=dateOfBirth;
		this.insuranceType=insuranceType;
	}
}
