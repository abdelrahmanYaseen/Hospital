package hospital;
import java.util.Date;
import java.util.Scanner;

public abstract class Person {
	
	protected String ssn; 
	protected String name; 
	protected String gender; 
	protected Date dateOfBirth; 
	protected String insuranceType;
	public Person(String ssn,String name, String gender, Date dateOfBirth, String insuranceType) {
		this.ssn=ssn;
		this.name=name;
		this.gender=gender;
		this.dateOfBirth=dateOfBirth;
		this.insuranceType=insuranceType;
	}
	
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

	
//	public void getInfo() {
//		
//		Scanner input = new Scanner(System.in);
//		System.out.print("Enter the name  : ");
//		this.name = input.nextLine();
//		System.out.print("Enter the gender  : ");
//		this.gender = input.nextLine();
//		System.out.print("Enter the date of birth (dd-MM-yyy) : ");
//		this.dateOfBirth=Util.requestDate();
//		System.out.print("Enter the insurance type: ");
//		this.insuranceType = input.nextLine();
//		
//	}
}
