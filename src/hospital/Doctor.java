package hospital;

import java.util.Date;

/**
 * This class represents the doctors who work in the hospital
 *  @author yaseen
 *
 */
public class Doctor {

	/**
	 * The social security number
	 */
	private String ssn;
	/**
	 * The name of the doctor
	 */
	private String name;
	/**
	 * The gender of the doctor
	 */
	private String gender;
	/**
	 * The date of birth of the doctor
	 */
	private Date dateOfBirth;
	
	/**
	 * This method is used to construct a Doctor Object
	 * @param ssn The social security number
	 * @param name The name of the doctor
	 * @param gender The gender of the doctor
	 * @param dateOfBirth The date of birth of the doctor
	 */
	public Doctor(String ssn,String name, String gender, Date dateOfBirth) {
		this.ssn=ssn;
		this.name=name;
		this.gender=gender;
		this.dateOfBirth=dateOfBirth;
	}
	
	/**
	 * This method is used to print the details of the doctor.
	 */
	@Override
	public String toString() {
		
		return  "----------------- Doctor ----------------- " +"\nSSN : " + ssn +  "\nName : " + name + "\nGender : " + gender + "\nDate Of Birth : " 
				+ dateOfBirth + "\n";
	}
	/**
	 * This method is used to retrieve the SSN of the doctor.
	 * @return the ssn.
	 */
	public String getSsn() {
		return this.ssn;
	}
	
	
}
