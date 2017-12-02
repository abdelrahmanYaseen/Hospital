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
	private float moneyPaid;
	private String type;
	
	/**
	 * @return the doctorSSN
	 */
	public String getDoctorSSN() {
		return doctorSSN;
	}
	
	/**
	 * This method is used to construct a Treatment object.
	 * @param details The details of the treatment.
	 * @param description The description of the treatment.
	 * @param medication The medication used.
	 * @param the ssn of the supervising doctor.
	 */
	public Treatment(String details, String description,String medication,String doctorSSN, float cost, String type,String insuranceType) {
		this.details=details;
		this.description=description;
		this.medication=medication;
		this.doctorSSN=doctorSSN;
		this.cost=cost;
		this.type=type;
		setMoneyPaid(insuranceType);
	}
	public Treatment(HospitalManagementApplication H,String insuranceType) {
		Scanner input = new Scanner(System.in);
		int i=0;
		System.out.print("Enter the SSN of the supervising doctor: ");
		this.doctorSSN=Util.requestDoctorSsn(H);
		System.out.print("Enter the details of the treatment: ");
		this.details = input.nextLine();
		System.out.print("Enter the description of the treatment: ");
		this.description = input.nextLine();
		System.out.print("Enter the medication of the treatment: ");
		this.medication = input.nextLine();
		System.out.print("Enter the cost of the treatment: ");
		this.cost = Float.parseFloat(input.nextLine());
		System.out.print("Enter the type of the treatment (M)ust/(O)ptional - Default is optinal : ");
		switch (input.nextLine()) {
		case "M":
			this.type="Must"; 
			break;
		default:
			this.type="Optional";
			break;
		}
		setMoneyPaid(insuranceType);
		
	}
	
	private void setMoneyPaid(String insuranceType) {
		switch (insuranceType) {
		case "Full":
			moneyPaid=0;
			break;
		case "Partial":
			moneyPaid=0;
			if(type.equals("Optional")) {
				moneyPaid=cost;
			}
			break;
		default:
			moneyPaid=cost;
			break;
		}
	}
	/**
	 * @return the moneyPaid
	 */
	public float getMoneyPaid() {
		return moneyPaid;
	}

	/**
	 * This method is used to print the details of the treatment.
	 */
	@Override
	public String toString() {
		return "\n Supervising doctor SSN :"+doctorSSN+"\n Details : \"" + 
				details +"\"\n Description :\"" +description+"\"\n Medication :\""
				+medication+"\n Cost :"+cost+"\n Type :"+type;
	}

	/**
	 * This method is used to create a new medical record list. 
	 * used when adding a new medical record.
	 * it  the user to enter the details,description and the medication used in the treatments.
	 * @return a list of treatments
	 */
	public static ArrayList<Treatment> requestTreatment(HospitalManagementApplication H,String insuranceType) {
		Scanner input = new Scanner(System.in);
		ArrayList<Treatment> treatments = new ArrayList<Treatment>();
		int i=0;
		boolean again=true;
		while(again && i++<10) {
			treatments.add(new Treatment(H,insuranceType));
			System.out.println("Enter 1 To add another Treatment to the current medical record\n Or  any other key to finsh. Then press <enter> key");
			again=Integer.parseInt(input.nextLine())==1;
		}
//		input.close();
		return treatments;
	}

	public float getCost() {
		return this.cost;
	}
	
	
}
