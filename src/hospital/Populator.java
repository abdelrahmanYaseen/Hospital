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
	public  Populator(ArrayList<Doctor> doctors,ArrayList<Patient> patients) {
		
		Date  date = null;
		try {
			date = new SimpleDateFormat("dd-MM-yyy").parse("11-6-1290");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		doctors.add(new Doctor("2175578","Yaseen","M",date));
//		doctors.add(new Doctor("2589985","Amairi","M",date));
//		doctors.add(new Doctor("1478875","Elosta","M",date));
//		doctors.add(new Doctor("7855554","Randomiana","F",date));
//		doctors.add(new Doctor("3698857","Derwish","M",date));
//		
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






















