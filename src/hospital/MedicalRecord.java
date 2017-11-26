package hospital;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * This class represents the medical record of a patient. 
 * @author yaseen
 *
 */
public class MedicalRecord {

	/**
	 * The date that the record is issued.
	 */
	private Date issueDate;
	
	/**
	 * This method is used to retrieve the issue date of the medical record
	 * @return issue date
	 */
	public Date getIssueDate() {
		return issueDate;
	}
	/**
	 * The treatments that the patient has got.
	 */
	private ArrayList<Treatment> treatments;
	
	/**
	 * This method is used to construct a Medical Record object.
	 * @param issueDate The date that the record is issued.
	 * @param treatments The treatments that the patient has got.
	 */
	public MedicalRecord(Date issueDate,ArrayList<Treatment> treatments) {
		this.issueDate=issueDate;
		this.treatments=treatments;
	}
	/**
	 * This method is used to print the details of the medical report.
	 * Including the 
	 */
	@Override
	public String toString() {
		String result="";
		result+="Issue Date : "+this.issueDate + "\n";
		for(Treatment t : treatments) {
			result+=t.toString();
		}
		return result;
	}
	/**
	 * This method is used to create a new medical record list. 
	 * used when adding a new patient.
	 * it also asks the user to enter the details of the treatments.
	 * @return a list of records.
	 */
	public static ArrayList<MedicalRecord> requestMedicalRecord(HospitalManagementApplication H) {
		Scanner input = new Scanner(System.in);
		ArrayList<MedicalRecord> medicalRecord = new ArrayList<MedicalRecord>();
		int i=0;
		boolean again=true;
		while(again && i<10) {
			System.out.print("Enter the issueDate of the medical record :(dd-MM-yyy) ");
			Date issueDate=Util.requestDate();
			ArrayList<Treatment> treatment = Treatment.requestTreatment(H);
			medicalRecord.add(new MedicalRecord(issueDate,treatment));
			System.out.println(" Enter 1 To add another medical record, Or any other key to finsh. Then press <enter>");
			again=input.nextInt()==1;
		}
		
		//input.close();
		return medicalRecord;
	}
}
