package hospital;
/**
 * <h1>Hospital Management Application</h1>
 * <p>small Java application to manage a small private hospital. It aims to maintain information about patients, doctors and treatments given in this hospital</p>
 * 
 * @author yaseen 
 * @version 2.0
 
 */


import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the main class. 
 * It maintains all the system. 
 *
 */
public class HospitalManagementApplication {
	/**
	 * This field is used to store all the doctors.
	 */
	public ArrayList<Doctor> doctors = new ArrayList<Doctor>();
	/**
	 * This field is used to store all the patients with their information.
	 */
	public ArrayList<Patient> patients= new ArrayList<Patient>();
	
	public ArrayList<Nurse> nurses = new ArrayList<Nurse>();
	
/**
 * Displays the Menu for the user
 * @return integer value that represents the option which is chosen by the user.
 */
	public  int menu() {
		Scanner input = new Scanner(System.in);
		boolean success=false;
		int option=-1;
		while(!success) {
			
			System.out.println("--------------------------");
			System.out.println("(  1 ) Add (Doctor,Patient,Nurse)");
			System.out.println("(  2 ) Delete (Doctor,Patient,Nurse)");
			System.out.println("(  3 ) Display Details (Doctor,Patient,Nurse)");
			System.out.println("(  4 ) Display Patient Treatment");
			System.out.println("(  5 ) Promote a junior doctor");
			System.out.println("(  6 ) Display patient department");
			System.out.println("(  7 ) Get available leave days");
			System.out.println("(  8 ) Retrieve the latest medical record of patient");
			System.out.println("(  9 ) Retrieve all the treatments");
			System.out.println("( 10 ) Get treatments income");
			System.out.println("( 11 ) Get budget status");
			System.out.println("( 12 ) List All Doctors");
			System.out.println("( 13 ) List All Patients");
			System.out.println("( 14 ) List All Nurses");
			System.out.println("( 15 ) Exit");
			System.out.println("--------------------------");
			System.out.print("Enter Option Number : ");
			option = input.nextInt();
			if (option > 0 && option < 16) {
				success=true;
			} else {
				System.out.println("Error");
			}
		}
//		input.close();
		return option;
	}
/**
 * This method is used to add a new doctor, by asking the user for the required attributes.
 *
 */
	
	public void add() {
		Scanner input = new Scanner(System.in);
		int option;
		boolean temp=true;
		do {
			if(!temp) {
				System.out.println("Choose either 1, 2, or 3");
			}
			System.out.print("Enter 1 to add doctor, 2 to add a patient, 3 to add a nurse");
			option = Integer.parseInt(input.nextLine());
			temp=false;
		}while(!((option==1)||(option==2)||(option==3)));
		
		switch (option) {
		case 1:
				addDoctor();
			break;
		case 2:
				addPatient();
			break;
		case 3 :
				addNurse();
			break;

		default:
			break;
		}
//		input.close();
	}
	
	public void delete() {
		Scanner input = new Scanner(System.in);
		int option;
		boolean temp=true;
		do {
			if(!temp) {
				System.out.println("Choose either 1, 2, or 3");
			}
			System.out.print("Enter 1 to delete doctor, 2 to delete a patient, 3 to delete a nurse");
			option = Integer.parseInt(input.nextLine());
			temp=false;
		}while(!((option==1)||(option==2)||(option==3)));
		
		switch (option) {
		case 1:
				deleteDoctor();
			break;
		case 2:
				deletePatient();
			break;
		case 3 :
				deleteNurse();
			break;

		default:
			break;
		}
//		input.close();
	}
	
	public void details() {
		Scanner input = new Scanner(System.in);
		int option;
		boolean temp=true;
		do {
			if(!temp) {
				System.out.println("Choose either 1, 2, or 3");
			}
			System.out.print("Enter 1 to display the details of doctor, 2 for patient, 3 for nurse");
			option = Integer.parseInt(input.nextLine());
			temp=false;
		}while(!((option==1)||(option==2)||(option==3)));
		
		String ssn;
		switch (option) {
		case 1:
			System.out.print("Enter the SSN : ");
			
			ssn = input.nextLine();
			System.out.println(getDoctorDetails(ssn));
			break;
		case 2:
			System.out.print("Enter the SSN : ");
			ssn = input.nextLine();
			System.out.println(getPatientDetails(ssn));
			break;
		case 3 :
			System.out.print("Enter the SSN : ");
			ssn = input.nextLine();
			System.out.println(getNurseDetails(ssn));
			break;

		default:
			break;
		}
//		input.close();
	}
	
	public void addDoctor() {

		Scanner input = new Scanner(System.in);
		Doctor doctor= new Doctor(this);
		
		System.out.println("Is this a senior or junior ? (S/J) Default is Senior");
		String option=input.nextLine();
		switch (option) {
		case "J":
				doctors.add(new Junior(doctor,this));
			break; 
		default:
			doctors.add(new Senior(doctor));
			break;
		}
		//doctors.add(doctor);
		System.out.println("Added successfully.");
		
	}
	
	public void addNurse() {

		Nurse nurse = new Nurse(this);
		nurses.add(nurse);
		System.out.println("Added successfully.");
		
	}

	
	
	/**
	 * This method is used to add a new patient.
	 * It asks the user to enter the necessary information.
	 */
	
	public void addPatient() {
		Patient p = new Patient(this);
		patients.add(p);
	}
	
	
	/**
	 * 

	 * @param ssn the ssn of the doctor/patient
	 * @param type The type of the element of interest (doctor/patient)
	 * @return true if the doctor/patient exist in the system. false otherwise.
	 */
	public  Object isExist(String ssn,String type){
			if(type.equals("Doctor")) {
				for (Doctor doctor : doctors) {
					if(doctor.getSsn().equals(ssn))
						return doctor;
				}
			}else if (type.equals("Senior")) {
				for (Doctor doctor : doctors) {
					if(doctor.getSsn().equals(ssn) && (doctor instanceof Senior))
						return doctor;
				}
			}else if (type.equals("Junior")) {
				for (Doctor doctor : doctors) {
					if(doctor.getSsn().equals(ssn) && (doctor instanceof Junior))
						return doctor;
				}
			}else if (type.equals("Patient")) {
				for (Patient patient : patients) {
					if(patient.getSsn().equals(ssn))
						return patient;
				}
			} else if (type.equals("Nurse")) {
				for (Nurse nurse: nurses) {
					if(nurse.getSsn().equals(ssn))
						return nurse;
				}
			}
			return null;
	}
	
	
/**
 * This method is used to delete a doctor.
 * It asks the user to provide the SSN number for the doctor who is needed to be deleted
 */
	public  void deleteDoctor() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the SSN of the doctor : ");
		String ssn = input.nextLine();
		for(Doctor d : doctors) {
			if(d.getSsn().equals(ssn)) {
				doctors.remove(d);
				System.out.println("Deleted");
				return;
			}
		}
//		input.close();
		System.out.println("Not Found");	
	}
	
	/**
	 * This method is used to delete a patient.
	 * It asks the user to enter the SSN for the patient that is to be deleted.
	 */
	public  void deletePatient() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the SSN of the patient : ");
		String ssn = input.nextLine();
		for(Patient d : patients) {
			if(d.getSsn().equals(ssn)) {
				patients.remove(d);
				System.out.println("Deleted");
				return;
			}
		}
//		input.close();
		System.out.println("Not Found");
	}
	
	public  void deleteNurse() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the SSN of the nurse : ");
		String ssn = input.nextLine();
		for(Nurse d : nurses) {
			if(d.getSsn().equals(ssn)) {
				nurses.remove(d);
				System.out.println("Deleted");
				return;
			}
		}
//		input.close();
		System.out.println("Not Found");
	}
	
	/**
	 * This method is used to retrieve the details of the doctor
	 * @param ssn, the social security number  of the doctor of interest
	 * @return a string of all the details of the doctor if it is found.
	 */
	public  String getDoctorDetails(String ssn) {
		
		for(Doctor d : doctors) {
			if(d.getSsn().equals(ssn))
				return d.toString();
		}
		return "Not Found";
	}
/**
 * This method is used to retrieve the details of the patient
 * @param SSN, the social security number  of the patient of interest
 * @return a string of the details of the patient if it is found.
 */
	public String getPatientDetails(String ssn) {
		for(Patient d : patients) {
			if(d.getSsn().equals(ssn))
				return d.toString();
		}
		return "Not Found";
	}

	public String getNurseDetails(String ssn) {
		for(Nurse d : nurses) {
			if(d.getSsn().equals(ssn))
				return d.toString();
		}
		return "Not Found";
	}
	
	/**
	 * This method is used to retrieve the treatments of the patient given the ssn
	 * @param ssn
	 * @return
	 */
	public String getPatientTreatment(String ssn) {
		for(Patient d : patients) {
			if(d.getSsn().equals(ssn))
				return d.getMedicalRecords().toString();
		}
		return "Not Found";
	}

/**
 * This method is used to print all the doctors registered.
 */
	public  void listDoctors() {
		System.out.println(doctors);
	}
/**
 * This method is used to print all the patients registered.
 */
	public  void listPatients() {
		System.out.println(patients);
	}

	
	/**
	 * This method is used to display the latest medical record of a patient. 
	 * it asks the user for the ssn of the patient of interest.
	 * @return
	 */
	private MedicalRecord requestLatestMedicalRecord() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the SSN of the patient : ");
		String ssn=scanner.nextLine();
		boolean found = false;
		for (Patient patient : patients) {
			if(patient.getSsn().equals(ssn)) {
				found = true;
				return patient.getLatestMedicalRecord();
			} 
		}
		if(!found) {
			System.out.println("No patient with the given ssn");
		}
		return null;
	}
	
	public static void main(String[] args) {
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		ArrayList<Patient> patients = new ArrayList<Patient>();
		ArrayList<Nurse> nurses= new ArrayList<Nurse>();
//		new Populator(doctors, patients);

		Scanner input = new Scanner(System.in);
		HospitalManagementApplication H = new HospitalManagementApplication();
		H.doctors = doctors;
		H.patients = patients;
		H.nurses= nurses;
		boolean run = true; 
		while (run) {
			int option = H.menu();
			switch (option) {
			case 1: {
						H.add();		
				}
				break;
			case 2: {
				H.delete();
			}
				break;
			case 3: {
				H.details();
			}
				break;
			case 4: {
//				Scanner input = new Scanner(System.in);
				System.out.print("Enter the SSN : ");
				boolean found=false;
				String ssn = input.nextLine();
				for (Patient d : patients) {
					if (d.getSsn().equals(ssn)) {
						d.displayMedicalRecords();
						found=true;
					}
				}
				if(!found)System.out.println("Not Found");
				
				
				
			}
				break;
			case 5: {// Promote Junior to Senior
//				Scanner input = new Scanner(System.in);
				System.out.println("Enter the ssn of the junior doctor to promote:");
				String ssn = input.nextLine();
				Doctor d;
				if((d=(Doctor) H.isExist(ssn,"Junior"))!=null) {
					doctors.add(new Senior(d));
					doctors.remove(d);
					System.out.println("Promoted successfully.");
				}
			}
				break;
			case 6: {// display patient department ( dep of latest treatment )
				System.out.println("Enter the ssn of the patient :");
				String ssn=input.nextLine();
				Patient p;
				if((p=(Patient)H.isExist(ssn, "Patient"))!=null) {
					System.out.println(p.getDepartment(H));
				} else {
					System.out.println("Not found");
				}
			}
				break;
			case 7: {// diaplay patient treatment
				
			}
				break;
			case 8: {
				System.out.println(doctors);
			}
				break;
			case 9: {
				System.out.println(patients);
			}
				break;
			case 10: {
				MedicalRecord result = H.requestLatestMedicalRecord();
				if(result!=null)
					System.out.println(result);
			}
				break;
			case 11: {
				for (Patient patient : patients) {
					System.out.println(patient);
					System.out.println(patient.getMedicalRecords());
				}
			}
				break;
			case 12: {
				System.out.println(doctors);
			}
				break;
			case 13: {
				System.out.println(patients);
			}
				break;
			case 14: {
				System.out.println(nurses);
			}
				break;
			case 15: {
				run=false;
			}
				break;

			default:
				input.close();
				break;
			}
		}
		// System.out.println(patients);
	}
	


}
