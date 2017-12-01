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
		
		Date  date = null;
		try {
			date = new SimpleDateFormat("dd-MM-yyy").parse("11-6-1290");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Doctor d = new Doctor("1","Yaseen","Male","Full",date,25,300000,"Nero","Neroscience");
		Senior s = new Senior(d,"Employment History sample 1");
		doctors.add(s);
		d = new Doctor("2","Amairi","Male","Partial",date,15,100000,"Arms","ArmScience");
		Junior j = new Junior(d,date,date,"1");
		doctors.add(j);
		ArrayList<Treatment> ta = new ArrayList<Treatment>();
		Treatment t = new Treatment("Some details", "A describtive description", "some medication", "1", 2500, "Must");
		ta.add(t);
		MedicalRecord m = new MedicalRecord(date, ta);
		ArrayList<MedicalRecord> ma = new ArrayList<MedicalRecord>();
		ma.add(m);
		Patient p = new Patient("3", "Darwish", "male", date, "full", 25, ma, date);
		patients.add(p);
		Nurse n = new Nurse("4", "Berna", "Female", date, "Full", 250000, 25, "Nursing");
		nurses.add(n);
//		ArrayList<Treatment> tmpT = new ArrayList<Treatment>();
//		tmpT.add(new Treatment("Hyperkalemia","Hyperkalemia can be difficult to diagnose clinically because symptoms may be vague or absent. ","Calcium (either gluconate or chloride): Reduces the risk of ventricular fibrillation caused by hyperkalemia.","2175578"));
//		tmpT.add(new Treatment("Anemia","Treatment for this form of anemia usually involves taking iron supplements and making changes to your diet.","If the underlying cause of iron deficiency is loss of blood — other than from menstruation ","2175578"));
//		ArrayList<MedicalRecord> tmpM = new ArrayList<MedicalRecord>();
//		tmpM.add(new MedicalRecord(date,tmpT));
//		patients.add(new Patient("6985574","Foo","F",date,(float) 90.2,tmpM));
//		
//		tmpT = new ArrayList<Treatment>();
//		tmpT.add(new Treatment("A","B","C","2175578"));
//		tmpT.add(new Treatment("F","E","D","2175578"));
//		tmpM = new ArrayList<MedicalRecord>();
//		tmpM.add(new MedicalRecord(date,tmpT));
//		patients.add(new Patient("1475589","Bar","M",date,(float) 84.7,tmpM));
	}
	
}






















