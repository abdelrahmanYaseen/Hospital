package hospital;
import java.util.Date;
import java.util.Scanner;

/**
 * This abstract class represents Person, with the basic common information
 * @author yaseen
 *
 */
public abstract class Person {
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the insuranceType
	 */
	public String getInsuranceType() {
		return insuranceType;
	}

	/**
	 * @param insuranceType the insuranceType to set
	 */
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	/**
	 * The ssn of the person
	 */
	protected String ssn; 
	/**
	 * The name of the person
	 */
	protected String name; 
	/**
	 * The gender of the person
	 */
	protected String gender; 
	/**
	 * The Birthday of the person
	 */
	protected Date dateOfBirth; 
	/**
	 * The insurance type of the person.
	 */
	protected String insuranceType;
	
	/**
	 * A constructor which takes the required information for the person as arguments
	 * @param ssn
	 * @param name
	 * @param gender
	 * @param dateOfBirth
	 * @param insuranceType
	 */
	public Person(String ssn,String name, String gender, Date dateOfBirth, String insuranceType) {
		this.ssn=ssn;
		this.name=name;
		this.gender=gender;
		this.dateOfBirth=dateOfBirth;
		this.insuranceType=insuranceType;
	}
	
	/**
	 * A constructor which asks the user to enter the required info for the person
	 */
	public Person() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the name  : ");
		this.name = input.nextLine();
		System.out.print("Enter the gender  : ");
		this.gender = input.nextLine();
		System.out.print("Enter the date of birth (dd-MM-yyy) : ");
		this.dateOfBirth=Util.requestDate();
		System.out.print("Enter the insurance type (F)ull- (P)artial - (N)ot covered (The default is N):");		
		switch (input.nextLine()) {
		case "F":
			this.insuranceType="Full";
			break;
		case "P":
			this.insuranceType="Partial";
			break;
		default:
			this.insuranceType="Not Covered";
			break;
		}
	}

	@Override
	public String toString() {
		return "\n SSN : " + ssn +  "\n Name : " + name + "\n Gender : " + gender + "\n Date Of Birth : " + dateOfBirth +"\n Insurance type :" + insuranceType;
	}
	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}

	
}
