package hospital;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents the treatment of the patient. it's generally a part of the medical record. 
 * @author yaseen
 *
 */
public class Treatment {
	
	private String details;
	private String description;
	private String medication;
	private String doctorSSN;
	private float cost;
	private String type;
	
	/**
	 * This method is used to construct a Treatment object.
	 * @param details The details of the treatment.
	 * @param description The description of the treatment.
	 * @param medication The medication used.
	 * @param the ssn of the supervising doctor.
	 */
	public Treatment(String details, String description,String medication,String doctorSSN, float cost, String type) {
		this.details=details;
		this.description=description;
		this.medication=medication;
		this.doctorSSN=doctorSSN;
		this.cost=cost;
		this.type=type;
	}
	
	/**
	 * This method is used to print the details of the treatment.
	 */
	@Override
	public String toString() {
		return "\nSupervising doctor SSN :"+doctorSSN+"\n Details : \"" + details +"\"\n Description :\"" +description+"\"\n Medication :\""+medication+"\"\n";
	}

	/**
	 * This method is used to create a new medical record list. 
	 * used when adding a new medical record.
	 * it  the user to enter the details,description and the medication used in the treatments.
	 * @return a list of treatments
	 */
	public static ArrayList<Treatment> requestTreatment(HospitalManagementApplication H) {
		Scanner input = new Scanner(System.in);
		ArrayList<Treatment> treatments = new ArrayList<Treatment>();
		int i=0;
		boolean again=true;
		String doctorSsn;
		while(again && i<10) {
			do {
				System.out.print("Enter the SSN of the supervising doctor: ");
				doctorSsn = input.nextLine();
			}while(!H.isExist(doctorSsn,"Doctor"));
			System.out.print("Enter the details of the treatment: ");
			String details = input.nextLine();
			System.out.print("Enter the description of the treatment: ");
			String description = input.nextLine();
			System.out.print("Enter the medication of the treatment: ");
			String medication = input.nextLine();
			System.out.print("Enter the cost of the treatment: ");
			float cost = input.nextFloat();
			System.out.print("Enter the type of the treatment: ");
			String type = input.nextLine();
			
			treatments.add(new Treatment(details,description,medication,doctorSsn,cost,type));
			System.out.println("Enter 1 To add another Treatment to the current medical record, Or  any other key to finsh. Then press <enter> key");
			again=input.nextInt()==1;
		}
//		input.close();
		return treatments;
	}
	
	
}
