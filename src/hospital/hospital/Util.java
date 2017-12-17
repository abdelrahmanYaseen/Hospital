package hospital;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * This class has some commonly-used method in this project
 * @author yaseen
 *
 */
public class Util {

	/**
	 * This method is used to create a Date object given the date in a string (with correct format)
	 * @param dateString
	 * @return Date object
	 * @throws ParseException
	 */
	public static Date createDate(String dateString) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
		Date date= sdf.parse(dateString);
		return date;
	}
	/**
	 * This method is used to request a date from the user.
	 * it makes sure that the user enters the date in an apropriate format.
	 * @return Date object
	 */
	public static Date requestDate(){
		Scanner input = new Scanner(System.in);
		String dateString;
		
		Date date;
		while(true) {
			try {
				 dateString=input.nextLine();
				 date =createDate(dateString);
				break;
			} catch (ParseException e) {
				System.out.println("Bad date format, try again !");
				continue;
			}
		}
		return date;
		
	}
	
	/**
	 * Asks the user to enter an ssn, and checks whether it exists or not in the system
	 * @param hospital
	 * @return the ssn
	 */
	public static String requestDoctorSsn(HospitalManagementApplication h) {
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		String ssn;
		while(!valid) {
			ssn=input.nextLine();
			if(h.isExist(ssn, "Doctor")!=null) {
				return ssn;
			}
			System.out.println("Not found, Try again :");
		}
		return null;
	}
	/**
	 * Asks the user to enter an ssn of a nurse, and checks whether it exists or not in the system
	 * @param hospital
	 * @return the ssn
	 */
	public static String requestNurseSsn(HospitalManagementApplication h) {
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		String ssn;
		while(!valid) {
			ssn=input.nextLine();
			if(h.isExist(ssn, "Nurse")!=null) {
				return ssn;
			}
			System.out.println("Not found, Try again :");
		}
		return null;
		
	}
	/**
	 * Asks the user to enter an ssn of a senior doctor, and checks whether it exists or not in the system
	 * @param hospital
	 * @return the ssn
	 */
	public static String requestSeniorSsn(HospitalManagementApplication h) {
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		String ssn;
		while(!valid) {
			ssn=input.nextLine();
			if(h.isExist(ssn, "Senior")!=null) {
				return ssn;
			}
			System.out.println("Not found, Try again :");
		}
		return null;
	}
	
	public static Float requestSalaryWithRange(float min, float max) {
		Scanner input = new Scanner(System.in);
		float salary;
		boolean valid = false;
		do {
			System.out.print("Enter the salary of this employee ("+min+"-"+max+"): ");
			salary=Float.parseFloat(input.nextLine());
			if(salary>max || salary<min) {
				System.out.println("Wrong range, try again :");
			} else {
				valid = true;
			}
		}while(!valid);
		return salary;
	}
	
}
