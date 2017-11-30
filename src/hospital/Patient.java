package hospital;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * This class represents the patients who are treated in the hospital
 * @author yaseen
 *
 */
public class Patient extends Person{

	private float bloodPressure;
	/**
	 * All the medical records of the patient.
	 */
	private ArrayList<MedicalRecord> medicalRecords; 
	
	private Date firstVisitToHospital;
	/**
	 * This method is used to construct a Patient Object.
	 * @param ssn The social security number.
	 * @param name The name of the doctor.
	 * @param gender The gender of the doctor.
	 * @param dateOfBirth The date of birth of the doctor
	 * @param bloodPressure The Blood Pressure of the patient.
	 * @param medicalRecord All the medical records of the patient.
	 */
	public Patient(String ssn, String name, String gender, Date dateOfBirth, String insuranceType, float bloodPressure,ArrayList<MedicalRecord> medicalRecord, Date firstVisitToHospital) {
		super(ssn, name, gender, dateOfBirth, insuranceType);
			this.bloodPressure=bloodPressure;
			this.medicalRecords=medicalRecord;
			this.firstVisitToHospital=firstVisitToHospital;
	}
	public Patient(HospitalManagementApplication h) {
		super();
		Scanner input = new Scanner(System.in);
		String ssn;
		boolean temp=true;//used to give error message if the ssn is already in use
		do {
			if(!temp) {
				System.out.println("The SSN is already in use !");
			}
			System.out.print("Enter the SSN of the patient : ");
			ssn = input.nextLine();
			temp=false;
		}while(h.isExist(ssn, "Patient")!=null);
		super.ssn=ssn;
		System.out.print("Enter Blood Pressure of the patient : ");
		this.bloodPressure=Float.parseFloat(input.nextLine());
		System.out.print("Enter the date of first visit to hospital: ");
		this.firstVisitToHospital = Util.requestDate();
		this.medicalRecords = MedicalRecord.requestMedicalRecord(h);
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

		return "----------------- Patient -----------------\n" + super.toString() +
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
	
	public String getDepartment(HospitalManagementApplication h) {
		ArrayList<Treatment> treatments=getLatestMedicalRecord().getTreatments();
		Treatment lastTreatment =treatments.get(treatments.size()-1);
		String doctorSsn = lastTreatment.getDoctorSSN();
		Doctor d = (Doctor)h.isExist(doctorSsn,"Doctor");
		
		//HEEREEE , RETURNS NULL !!!!! Exception
		return d.getDepartmentWorksIn();
	}

	
}
