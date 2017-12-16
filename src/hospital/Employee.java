package hospital;


/**
 * This interface contains the common methods used by the Doctors and Nurses
 * @author yaseen
 *
 */
public interface Employee {
	/**
	 * This method is used to get the salary of the employee
	 */
	float salary();
	/**
	 * This method is used to get the available leave days
	 */
	int annualLeaveLeft();
	
	/**
	 * This method is used when the employee asks for a leave.
	 * it subtracts the number of days from the available leave days.
	 * @param numberOfDays
	 */
	void goAnnualLeave(int numberOfDays);

}
