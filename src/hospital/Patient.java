package hospital;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class represents the patients who are treated in the hospital
 * @author yaseen
 *
 */
public class Patient {
	/**
	 * The social security number.
	 */
	private String ssn;
	/**
	 * The name of the patient.
	 */
	private String name;
	/**
	 * The gender of the patient.
	 */
	private String gender;
	/**
	 * The date of birth of the patient.
	 */
	private Date dateOfBirth;
	/**
	 * The Blood Pressure of the patient.
	 */
	private float bloodPressure;
	/**
	 * All the medical records of the patient.
	 */
	private ArrayList<MedicalRecord> medicalRecords; 
	
	
	/**
	 * This method is used to construct a Patient Object.
	 * @param ssn The social security number.
	 * @param name The name of the doctor.
	 * @param gender The gender of the doctor.
	 * @param dateOfBirth The date of birth of the doctor
	 * @param bloodPressure The Blood Pressure of the patient.
	 * @param medicalRecord All the medical records of the patient.
	 */
	public Patient(String ssn, String name, String gender, Date dateOfBirth, float bloodPressure,ArrayList<MedicalRecord> medicalRecord) {
		this.ssn=ssn;
		this.name=name;
		this.gender=gender;
		this.dateOfBirth=dateOfBirth;
		this.bloodPressure=bloodPressure;
		this.medicalRecords=medicalRecord;
	}

	/**
	 * This method is used to retrieve a list of the medical records of the patient.
	 * @return a list of all the Medical Records
	 */
	public ArrayList<MedicalRecord> getMedicalRecords() {
		return medicalRecords;
	}
	
	/**
	 * This method acts like a setter of the Medical Records list of the patient
	 * @param medicalRecords
	 */
	public void setMedicalRecords(ArrayList<MedicalRecord> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}
	/**
	 * This method is used to display the medical records with their treatments details for the patient.
	 */
	public void displayMedicalRecords() {
		System.out.println(medicalRecords);
	}
	
	/**
	 * This method is used to print the details of the patient.
	 */
	@Override
	public String toString() {

		return "----------------- Patient ----------------- " +"\n SSN : " + ssn +  "\n Name : " + name + "\n Gender : " + gender + "\n Date Of Birth : " + dateOfBirth +
				"\n Blood Pressure : " + bloodPressure + "\n";
	}
	/**
	 * This method is used to retrieve the ssn number of the patient.
	 * @return
	 */
	public String getSsn() {
		return this.ssn;
	}
	
	/**
	 * This method returns the medical record given the issue date.
	 * @param issuedate
	 * @return
	 */

	
	public MedicalRecord getMedicalRecord(Date issuedate) {
		for (MedicalRecord medicalRecord : medicalRecords) {
			if(medicalRecord.getIssueDate().equals(issuedate)) {
				return medicalRecord;
			}
		}
		return null;
		
	}
	/**
	 * This method returns the most recent medical record
	 * @return
	 */
	public MedicalRecord getLatestMedicalRecord() {
		MedicalRecord tmp = medicalRecords.get(0);
		for (MedicalRecord medicalRecord : medicalRecords) {
			if(tmp.getIssueDate().before(medicalRecord.getIssueDate())) {
				tmp=medicalRecord;
			}
		}
		return tmp;
	}

	
}
