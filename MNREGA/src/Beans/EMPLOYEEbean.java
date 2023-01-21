package Beans;

public class EMPLOYEEbean {

	String empID;
	String empName;
	String status;
	int wageEarned;
	int numOfDaysWork;
	String gpmSupervise;
	String proWorking;
	
	public EMPLOYEEbean(String empID, String empName, String status, int wageEarned, int numOfDaysWork,
			String gpmSupervise, String proWorking) {
		super();
		this.empID = empID;
		this.empName = empName;
		this.status = status;
		this.wageEarned = wageEarned;
		this.numOfDaysWork = numOfDaysWork;
		this.gpmSupervise = gpmSupervise;
		this.proWorking = proWorking;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getWageEarned() {
		return wageEarned;
	}

	public void setWageEarned(int wageEarned) {
		this.wageEarned = wageEarned;
	}

	public int getNumOfDaysWork() {
		return numOfDaysWork;
	}

	public void setNumOfDaysWork(int numOfDaysWork) {
		this.numOfDaysWork = numOfDaysWork;
	}

	public String getGpmSupervise() {
		return gpmSupervise;
	}

	public void setGpmSupervise(String gpmSupervise) {
		this.gpmSupervise = gpmSupervise;
	}

	public String getProWorking() {
		return proWorking;
	}

	public void setProWorking(String proWorking) {
		this.proWorking = proWorking;
	}

	@Override
	public String toString() {
		return "empID: " + empID +"\n"+ 
	           "empName: " + empName +"\n"+ 
			   "status: " + status +"\n"+
			   "wageEarned: "+ wageEarned + "\n"+
			   "numOfDaysWork: " + numOfDaysWork +"\n"+ 
			   "gpmSupervise: " + gpmSupervise + "\n"+
			   "proWorking: "+ proWorking+"\n"+
			    "--------------------------------------------";
	}
		
}
