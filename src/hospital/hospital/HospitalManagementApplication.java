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
 */
public class HospitalManagementApplication {
	/**
	 * This field is used to store all the doctors.
	 */
	public ArrayList<Person> doctors = new ArrayList<Person>();
	/**
	 * This field is used to store all the patients with their information.
	 */
	public ArrayList<Person> patients= new ArrayList<Person>();
	/**
	 * This field is used to store all the nurses with their information.
	 */
	public ArrayList<Person> nurses = new ArrayList<Person>();
	
	/**
	 * The constructor of the application.
	 * it initializes the lists and calls the populator.
	 */
	public HospitalManagementApplication() {
		this.doctors=new ArrayList<Person>();
		this.patients=new ArrayList<Person>();
		this.nurses=new ArrayList<Person>();
		new Populator(this.doctors,this.patients,this.nurses);
	}
	
	/**
	 * Displays the Menu for the user
	 * @return integer value that represents the option which is chosen by the user.
	 */
	public  int menu() {
		Scanner input = new Scanner(System.in);
		boolean success=false;
		int option=-1;
		while(!success) {
			
			System.out.println("__________________________");
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
			System.out.println("( 15 ) Go for a leave");
			System.out.println("( 16 ) Exit");
			System.out.println("__________________________");
			System.out.print("Enter Option Number : ");
			option = input.nextInt();
			if (option > 0 && option < 17) {
				success=true;
			} else {
				System.out.println("Error");
			}
		}
//		input.close();
		return option;
	}
	
	/**
	 * This method is used to add a new doctor,patient or nurse , by asking the user for the required attributes.
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
	
	/**
	 * @return the doctors
	 */
	public ArrayList<Person> getDoctors() {
		return doctors;
	}

	/**
	 * @param doctors the doctors to set
	 */
	public void setDoctors(ArrayList<Person> doctors) {
		this.doctors = doctors;
	}

	/**
	 * @return the patients
	 */
	public ArrayList<Person> getPatients() {
		return patients;
	}

	/**
	 * @param patients the patients to set
	 */
	public void setPatients(ArrayList<Person> patients) {
		this.patients = patients;
	}

	/**
	 * @return the nurses
	 */
	public ArrayList<Person> getNurses() {
		return nurses;
	}

	/**
	 * @param nurses the nurses to set
	 */
	public void setNurses(ArrayList<Person> nurses) {
		this.nurses = nurses;
	}

	/**
	 * This method is used to delete a doctor,patient or nurse , given the ssn.
	 */
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
	
	/**
	 * This method is used to print the details of the patient, doctor, or nurse 
	 */
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
		} while(!((option==1)||(option==2)||(option==3)));
		
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
	
	/**
	 * This method is used to ask the user to enter the required info to add a doctor to the hospital
	 */
	public void addDoctor() {

		Scanner input = new Scanner(System.in);
		Doctor doctor= new Doctor(this);
		boolean valid = false;
		System.out.println("Is this a senior or junior ? (S/J) Default is Senior");
		String option=input.nextLine();
		Float salary;
		switch (option) {
		case "J":
			
				doctor.setSalary(Util.requestSalaryWithRange(5000, 10000));
				doctors.add(new Junior(doctor,this));
			break; 
		default:
			doctor.setSalary(Util.requestSalaryWithRange(10000, 20000));
			doctors.add(new Senior(doctor,this));
			break;
		}
		System.out.println("Added successfully.");
		
	}
	
	/**
	 * This method is used to ask the user to enter the required info to add a nurse to the hospital
	 */
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
				for (Person doctor : doctors) {
					if(doctor.getSsn().equals(ssn))
						return doctor;
				}
			}else if (type.equals("Senior")) {
				for (Person doctor : doctors) {
					if(doctor.getSsn().equals(ssn) && (doctor instanceof Senior))
						return doctor;
				}
			}else if (type.equals("Junior")) {
				for (Person doctor : doctors) {
					if(doctor.getSsn().equals(ssn) && (doctor instanceof Junior))
						return doctor;
				}
			}else if (type.equals("Patient")) {
				for (Person patient : patients) {
					if(patient.getSsn().equals(ssn))
						return patient;
				}
			} else if (type.equals("Nurse")) {
				for (Person nurse: nurses) {
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
		for(Person d : doctors) {
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
		for(Person d : patients) {
			if(d.getSsn().equals(ssn)) {
				patients.remove(d);
				System.out.println("Deleted");
				return;
			}
		}
//		input.close();
		System.out.println("Not Found");
	}
	
	/**
	 * This method is used to delete a nurse.
	 * It asks the user to enter the SSN for the nurse that is to be deleted.
	 */
	public  void deleteNurse() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the SSN of the nurse : ");
		String ssn = input.nextLine();
		for(Person d : nurses) {
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
		
		for(Person d : doctors) {
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
		for(Person d : patients) {
			if(d.getSsn().equals(ssn))
				return d.toString();
		}
		return "Not Found";
	}

	/**
	 * This method is used to retrieve the details of the Nurse
	 * @param SSN, the social security number  of the nurse of interest
	 * @return a string of the details of the nurse if it is found.
	 */
	public String getNurseDetails(String ssn) {
		for(Person d : nurses) {
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
		for(Person d : patients) {
			if(d.getSsn().equals(ssn))
				return ((Patient) d).getMedicalRecords().toString();
		}
		return "Not Found";
	}

	/**
	 * 	This method is used to print all the doctors registered.
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
		for (Person patient : patients) {
			if(patient.getSsn().equals(ssn)) {
				found = true;
				return ((Patient) patient).getLatestMedicalRecord();
			} 
		}
		if(!found) {
			System.out.println("No patient with the given ssn");
		}
		return null;
	}
	
	/**
	 * This method is used to calculate the total income of the treatments
	 * it goes through the list of patients and checks the costs
	 * maintaining the constrains of the type of the treatment and the 
	 * insurance type of the patient
	 * @return The total income of the treatments
	 */
	public float getTreatmentsIncome() {
		float result=0;
		for (Person p : patients) {
			for (MedicalRecord m : ((Patient) p).getMedicalRecords()) {
				for (Treatment t : m.getTreatments()) {
					result+=t.getMoneyPaid();
				}
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		HospitalManagementApplication H = new HospitalManagementApplication();
		
		Scanner input = new Scanner(System.in);
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
				for (Person d : H.patients) {
					if (d.getSsn().equals(ssn)) {
						((Patient) d).displayMedicalRecords();
						found=true;
					}
				}
				if(!found)System.out.println("Not Found");
			}
				break;
			case 5: {// Promote Junior to Senior
//				Scanner input = new Scanner(System.in);
				System.out.println("Enter the ssn of the junior doctor to promote:");
				H.getPromoted(input.nextLine());
				
			}
				break;
			case 6: {// display patient department ( dep of latest treatment )
				System.out.println("Enter the ssn of the patient :");
				H.getPatientDept(input.nextLine());
			}
				break;
			case 7: {
				int result;
				if((result = H.getLeaveDays())!=-1)
					System.out.println(result+" days left\n");
				else
					System.out.println("Not found");
			}
				break;
			case 8: {
				MedicalRecord result = H.requestLatestMedicalRecord();
				if(result!=null)
				System.out.println(result);
			}
				break;
			case 9: {
				for (Person patient : H.patients) {
					System.out.println(patient);
					System.out.println(((Patient) patient).getMedicalRecords());
				}
			}
				break;
			case 10: {	//Get treatments income
				System.out.println("The total treatments income : "+ H.getTreatmentsIncome());
			}
				break;
			case 11: {
				float delta = H.getBudgetStatus();
				System.out.println(delta);
			}
				break;
			case 12: {
				System.out.println(H.doctors);
			}
				break;
			case 13: {
				System.out.println(H.patients);
			}
				break;
			case 14: {
				System.out.println(H.nurses);
			}
				break;
			case 15: {
				System.out.println("Enter the ssn for the employee who want to leave : ");
				String Ssn = input.nextLine();
				System.out.println("Enter the number of days :");
				int days = Integer.parseInt(input.nextLine());
				H.goAnnualLeave(Ssn, days);
				
			}
			break;
			case 16: {
				run=false;
			}
				break;
			default:
				input.close();
				break;
			}
		}
	}
	
	/**
	 * This method is used to calculate the budget of the hospital
	 * by taking the difference between the treatments' income and the 
	 * salaries that the hospital has to pay.
	 * @return
	 */
	private float getBudgetStatus() {
		float totalSalaries=0;
		for (Person d : this.doctors) {
			totalSalaries+=((Doctor) d).salary();
		}
		for (Person d : this.nurses) {
			totalSalaries+=((Nurse) d).salary();
		}
		float delta = this.getTreatmentsIncome()-totalSalaries;
		return delta;
	}

	/**
	 * This method is responsible of displaying the department of the patient.
	 * specifically the department of the last treatment.
	 * @param ssn
	 */
	private void getPatientDept(String ssn) {
		Patient p;
		if((p=(Patient)this.isExist(ssn, "Patient"))!=null) {
			System.out.println(p.getDepartment(this));
		} else {
			System.out.println("Not found");
		}
		
	}

	/**
	 * This method is used to promote a junior doctor to be senior
	 * @param ssn of the junior
	 */
	private void getPromoted(String ssn) {
		Doctor d;
		Scanner input = new Scanner(System.in);
		if((d=(Doctor) this.isExist(ssn,"Junior"))!=null) {
			System.out.println("Enter the new salary :");
			d.setSalary(Float.parseFloat(input.nextLine()));
			this.doctors.add(new Senior(d,this));
			this.doctors.remove(d);
			System.out.println("Promoted successfully.");
		}
		
	}

	/**
	 * This function returns the available leave days for nurses and doctors 
	 * @return number of available leave days.
	 */
	public int getLeaveDays() {
		Scanner input = new Scanner(System.in);
		int option;
		boolean temp=true;
		do {
			if(!temp) {
				System.out.println("Choose either 1, or 2");
			}
			System.out.print("Enter 1 to display the details of doctor, 2 for nurse");
			option = Integer.parseInt(input.nextLine());
			temp=false;
		}while(!((option==1)||(option==2)));
		
		String ssn;
		switch (option) {
		case 1:
			System.out.println("Enter the ssn of the doctor");
			ssn = input.nextLine();
			Doctor d= (Doctor) isExist(ssn, "Doctor");
			if(d!=null) {
				return d.annualLeaveLeft();
			} else {
				return -1;
			}
		case 2:
			System.out.println("Enter the ssn of the nurse");
			ssn = input.nextLine();
			Nurse n= (Nurse) isExist(ssn, "Nurse");
			if(n!=null) {
				return n.annualLeaveLeft();
			} else {
				return -1;
			}
		}
		return -1;
	}
	
	/**
	 * This method is used when the employee asks for a leave.
	 * it subtracts the number of days from the available leave days.
	 * @param ssn
	 * @param noDays
	 */
	public void goAnnualLeave(String ssn, int noDays) {
		Doctor d;Nurse n;
		if((d=(Doctor)this.isExist(ssn, "Doctor"))!=null) {
			d.goAnnualLeave(noDays);
			System.out.println("Available leave days :"+d.annualLeaveLeft());
			
		} else if((n=(Nurse)this.isExist(ssn, "Nurse"))!=null) {
			n.goAnnualLeave(noDays);
			System.out.println("Available leave days :"+n.annualLeaveLeft());
		} else {
			System.out.println("Not found");
		}
		
	}
}

