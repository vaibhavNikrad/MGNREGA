package com.Model;

public class Project {

	int proID;
	String proName;
	int totalCost;
	int balanceCost;
	int wagePerEmp;
	int employeeRequired;
	String dateOfStrat;
	String dateOfEnd;
	String bdoSupervise;
	
	
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Project(int proID, String proName, int totalCost, int balanceCost, int wagePerEmp, int employeeRequired,
			String dateOfStrat, String dateOfEnd,  String bdoSupervise) {
		super();
		this.proID = proID;
		this.proName = proName;
		this.totalCost = totalCost;
		this.balanceCost = balanceCost;
		this.wagePerEmp = wagePerEmp;
		this.employeeRequired = employeeRequired;
		this.dateOfStrat = dateOfStrat;
		this.dateOfEnd = dateOfEnd;
		
		this.bdoSupervise = bdoSupervise;
	}



	public int getProID() {
		return proID;
	}



	public void setProID(int proID) {
		this.proID = proID;
	}



	public String getProName() {
		return proName;
	}



	public void setProName(String proName) {
		this.proName = proName;
	}



	public int getTotalCost() {
		return totalCost;
	}



	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}



	public int getBalanceCost() {
		return balanceCost;
	}



	public void setBalanceCost(int balanceCost) {
		this.balanceCost = balanceCost;
	}



	public int getWagePerEmp() {
		return wagePerEmp;
	}



	public void setWagePerEmp(int wagePerEmp) {
		this.wagePerEmp = wagePerEmp;
	}



	public int getEmployeeRequired() {
		return employeeRequired;
	}



	public void setEmployeeRequired(int employeeRequired) {
		this.employeeRequired = employeeRequired;
	}



	public String getDateOfStrat() {
		return dateOfStrat;
	}



	public void setDateOfStrat(String dateOfStrat) {
		this.dateOfStrat = dateOfStrat;
	}



	public String getDateOfEnd() {
		return dateOfEnd;
	}



	public void setDateOfEnd(String dateOfEnd) {
		this.dateOfEnd = dateOfEnd;
	}


	public String getBdoSupervise() {
		return bdoSupervise;
	}



	public void setBdoSupervise(String bdoSupervise) {
		this.bdoSupervise = bdoSupervise;
	}



	@Override
	public String toString() {
		return "PROJECTbean [proID=" + proID + ", proName=" + proName + ", totalCost=" + totalCost + ", balanceCost="
				+ balanceCost + ", wagePerEmp=" + wagePerEmp + ", employeeRequired=" + employeeRequired
				+ ", dateOfStrat=" + dateOfStrat + ", dateOfEnd=" + dateOfEnd + ", bdoSupervise=" + bdoSupervise + "]";
	}



	
	
	
	

	
}
