package hospital;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class a TEST class and it's used mainly to generate some doctors and patients
 * @author yaseen
 *
 */
public class Populator {
	/**
	 * This method is used to  generate some doctors and patients
	 * @param doctors
	 * @param patients
	 */
	public  Populator(ArrayList<Person> doctors,ArrayList<Person> patients,ArrayList<Person> nurses) {
		
		Date  date1 = null;
		try {
			date1 = new SimpleDateFormat("dd-MM-yyy").parse("28-7-2009");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date  date2 = null;
		try {
			date2 = new SimpleDateFormat("dd-MM-yyy").parse("29-9-2017");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Adding doctors
		
		ArrayList<String> nursesSsn= new ArrayList<String>();
		ArrayList<String> seniorsSsn= new ArrayList<String>();
		nursesSsn.add("111");
		nursesSsn.add("222");
		nursesSsn.add("333");
		seniorsSsn.add("1");
		seniorsSsn.add("2");
		seniorsSsn.add("4");
		
		Doctor d1 = new Doctor("1","Senior1","Male","Full",date1,25,15000,"Dep1","Spec1");
		Senior s1 = new Senior(d1,"EmploymentHistory1",nursesSsn);
		doctors.add(s1);

		Doctor d2 = new Doctor("2","Senior2","Female","Partial",date1,25,15000,"Dep2","Spec2");
		Senior s2 = new Senior(d2,"EmploymentHistory2",nursesSsn);
		doctors.add(s2);

		Doctor d3 = new Doctor("3","Senior3","male","Not Covered",date1,25,10000,"Dep3","Spec3");
		Senior s3 = new Senior(d3,"EmploymentHistory3",nursesSsn);
		doctors.add(s3);

		Doctor d4 = new Doctor("4","Senior4","Female","Full",date1,25,17000,"Dep4","Spec4");
		Senior s4 = new Senior(d4,"EmploymentHistory4",nursesSsn);
		doctors.add(s4);

		Doctor d5 = new Doctor("5","Senior5","male","Not Covered",date1,25,15000,"Dep5","Spec5");
		Senior s5 = new Senior(d5,"EmploymentHistory5",nursesSsn);
		doctors.add(s5);


		Doctor j1 = new Doctor("11","Junior1","Male","Full",date1,25,7000,"Dep1","Spec1");
		Junior J1 = new Junior(j1,date1,date2,"1");
		doctors.add(J1);

		Doctor j2 = new Doctor("22","Junior2","Female","Partial",date1,25,6000,"Dep2","Spec2");
		Junior J2 = new Junior(j2,date1,date2,"2");
		doctors.add(J2);

		Doctor j3 = new Doctor("33","Junior3","male","Not Covered",date1,25,5000,"Dep3","Spec3");
		Junior J3 = new Junior(j3,date1,date2,"3");
		doctors.add(J3);

		Doctor j4 = new Doctor("44","Junior4","Female","Full",date1,25,9000,"Dep4","Spec4");
		Junior J4 = new Junior(j4,date1,date2,"4");
		doctors.add(J4);

		Doctor j5 = new Doctor("55","Junior5","male","Not Covered",date1,25,8000,"Dep5","Spec5");
		Junior J5 = new Junior(j5,date1,date2,"5");
		doctors.add(J5); 
		
		//Adding nurses
		Nurse n1 = new Nurse("111", "Nurse1", "Female", date1, "Full", 3000, 20, "Dep1",seniorsSsn);
		nurses.add(n1);

		Nurse n2 = new Nurse("222", "Nurse2", "Female", date1, "Partial", 4000, 20, "Dep1",seniorsSsn);
		nurses.add(n2);

		Nurse n3 = new Nurse("333", "Nurse3", "Female", date1, "Full", 5000, 20, "Dep3",seniorsSsn);
		nurses.add(n3);

		Nurse n4 = new Nurse("444", "Nurse4", "Female", date1, "Partial", 3000, 20, "Dep4",seniorsSsn);
		nurses.add(n4);

		Nurse n5 = new Nurse("555", "Nurse5", "Female", date1, "Not Covered", 5000, 20, "Dep5",seniorsSsn);
		nurses.add(n5);

		
		//Adding patients
		
		ArrayList<Treatment> tl11 = new ArrayList<Treatment>();
		Treatment t11 = new Treatment("Details11", "Description11", "Medication11", "1", 1000, "Optional","Full");
		tl11.add(t11);
		MedicalRecord m11 = new MedicalRecord(date1, tl11);

		ArrayList<Treatment> tl12 = new ArrayList<Treatment>();
		Treatment t12 = new Treatment("Details12", "Description12", "Medication12", "1", 2000, "Must","Full");
		tl12.add(t12);
		MedicalRecord m12 = new MedicalRecord(date2, tl12);

		ArrayList<MedicalRecord> ml1 = new ArrayList<MedicalRecord>();
		ml1.add(m11);
		ml1.add(m12);

		Patient p1 = new Patient("1111", "Patient1", "male", date1, "Full", 90, ml1, date2);
		patients.add(p1);


		ArrayList<Treatment> tl21 = new ArrayList<Treatment>();
		Treatment t21 = new Treatment("Details21", "Description21", "Medication21", "1", 55000, "Optional","Partial");
		tl21.add(t21);
		MedicalRecord m21 = new MedicalRecord(date1, tl21);

		ArrayList<Treatment> tl22 = new ArrayList<Treatment>();
		Treatment t22 = new Treatment("Details22", "Description22", "Medication22", "1", 10000, "Must","Partial");
		tl22.add(t22);
		MedicalRecord m22 = new MedicalRecord(date2, tl22);

		ArrayList<MedicalRecord> ml2 = new ArrayList<MedicalRecord>();
		ml2.add(m21);
		ml2.add(m22);

		Patient p2 = new Patient("2222", "Patient2", "male", date2, "Partial", 90, ml2, date2);
		patients.add(p2);


		ArrayList<Treatment> tl31 = new ArrayList<Treatment>();
		Treatment t31 = new Treatment("Details31", "Description31", "Medication31", "1", 11000, "Optional","Not Covered");
		tl31.add(t31);
		MedicalRecord m31 = new MedicalRecord(date1, tl31);

		ArrayList<Treatment> tl32 = new ArrayList<Treatment>();
		Treatment t32 = new Treatment("Details32", "Description32", "Medication32", "1", 50000, "Must","Not Covered");
		tl32.add(t32);
		MedicalRecord m32 = new MedicalRecord(date2, tl32);

		ArrayList<MedicalRecord> ml3 = new ArrayList<MedicalRecord>();
		ml3.add(m31);
		ml3.add(m32);

		Patient p3 = new Patient("3333", "Patient3", "male", date1, "Not Covered", 90, ml3, date2);
		patients.add(p3);


		ArrayList<Treatment> tl41 = new ArrayList<Treatment>();
		Treatment t41 = new Treatment("Details41", "Description41", "Medication41", "1", 17000, "Optional","Partial");
		tl41.add(t41);
		MedicalRecord m41 = new MedicalRecord(date1, tl41);

		ArrayList<Treatment> tl42 = new ArrayList<Treatment>();
		Treatment t42 = new Treatment("Details42", "Description42", "Medication42", "1", 10000, "Must","Partial");
		tl42.add(t42);
		MedicalRecord m42 = new MedicalRecord(date2, tl42);

		ArrayList<MedicalRecord> ml4 = new ArrayList<MedicalRecord>();
		ml4.add(m41);
		ml4.add(m42);

		Patient p4 = new Patient("4444", "Patient4", "male", date1, "Partial", 90, ml4, date2);
		patients.add(p4);


		ArrayList<Treatment> tl51 = new ArrayList<Treatment>();
		Treatment t51 = new Treatment("Details51", "Description51", "Medication51", "1", 1000, "Optional","Full");
		tl51.add(t51);
		MedicalRecord m51 = new MedicalRecord(date1, tl51);

		ArrayList<Treatment> tl52 = new ArrayList<Treatment>();
		Treatment t52 = new Treatment("Details52", "Description52", "Medication52", "1", 1000, "Must","Full");
		tl52.add(t52);
		MedicalRecord m52 = new MedicalRecord(date2, tl52);

		ArrayList<MedicalRecord> ml5 = new ArrayList<MedicalRecord>();
		ml5.add(m51);
		ml5.add(m52);

		Patient p5 = new Patient("5555", "Patient5", "male", date1, "Full", 90, ml5, date2);
		patients.add(p5);
		
	}
	
}






















