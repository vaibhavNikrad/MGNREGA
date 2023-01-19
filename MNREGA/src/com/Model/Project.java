package com.Model;

public class Project {

	
	private String projectID;
	private String projectName;
	private int taotalBudget;
	private int balanceAmt;
	private int wagePerEmp;
	private int requiredEmployee;
	private String startingDate;
	private String endDate;
	private String status;
	private String bdoName;
	
	
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Project(String projectID, String projectName, int taotalBudget, int balanceAmt, int wagePerEmp,
			int requiredEmployee, String startingDate, String endDate, String status, String bdoName) {
		super();
		this.projectID = projectID;
		this.projectName = projectName;
		this.taotalBudget = taotalBudget;
		this.balanceAmt = balanceAmt;
		this.wagePerEmp = wagePerEmp;
		this.requiredEmployee = requiredEmployee;
		this.startingDate = startingDate;
		this.endDate = endDate;
		this.status = status;
		this.bdoName = bdoName;
	}



	public String getProjectID() {
		return projectID;
	}



	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}



	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public int getTaotalBudget() {
		return taotalBudget;
	}



	public void setTaotalBudget(int taotalBudget) {
		this.taotalBudget = taotalBudget;
	}



	public int getBalanceAmt() {
		return balanceAmt;
	}



	public void setBalanceAmt(int balanceAmt) {
		this.balanceAmt = balanceAmt;
	}



	public int getWagePerEmp() {
		return wagePerEmp;
	}



	public void setWagePerEmp(int wagePerEmp) {
		this.wagePerEmp = wagePerEmp;
	}



	public int getRequiredEmployee() {
		return requiredEmployee;
	}



	public void setRequiredEmployee(int requiredEmployee) {
		this.requiredEmployee = requiredEmployee;
	}



	public String getStartingDate() {
		return startingDate;
	}



	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}



	public String getEndDate() {
		return endDate;
	}



	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getBdoName() {
		return bdoName;
	}



	public void setBdoName(String bdoName) {
		this.bdoName = bdoName;
	}



	@Override
	public String toString() {
		return "Project [projectID=" + projectID + ", projectName=" + projectName + ", taotalBudget=" + taotalBudget
				+ ", balanceAmt=" + balanceAmt + ", wagePerEmp=" + wagePerEmp + ", requiredEmployee=" + requiredEmployee
				+ ", startingDate=" + startingDate + ", endDate=" + endDate + ", status=" + status + ", bdoName="
				+ bdoName + "]";
	}

	
	
	
	
	
	
	
	
	
	
}

