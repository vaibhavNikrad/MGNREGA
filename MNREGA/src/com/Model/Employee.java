package com.Model;

public class Employee {

private String empid;
private String ename;
private String status;
private int total_wage;
private int numberOfDaysWork;
private String GPMid;
private String Curr_project;



public Employee() {
	super();
	// TODO Auto-generated constructor stub
}



public Employee(String empid, String ename, String status, int total_wage, int numberOfDaysWork, String gPMid,
		String curr_project) {
	super();
	this.empid = empid;
	this.ename = ename;
	this.status = status;
	this.total_wage = total_wage;
	this.numberOfDaysWork = numberOfDaysWork;
	GPMid = gPMid;
	Curr_project = curr_project;
}



public String getEmpid() {
	return empid;
}



public void setEmpid(String empid) {
	this.empid = empid;
}



public String getEname() {
	return ename;
}



public void setEname(String ename) {
	this.ename = ename;
}



public String getStatus() {
	return status;
}



public void setStatus(String status) {
	this.status = status;
}



public int getTotal_wage() {
	return total_wage;
}



public void setTotal_wage(int total_wage) {
	this.total_wage = total_wage;
}



public int getNumberOfDaysWork() {
	return numberOfDaysWork;
}



public void setNumberOfDaysWork(int numberOfDaysWork) {
	this.numberOfDaysWork = numberOfDaysWork;
}



public String getGPMid() {
	return GPMid;
}



public void setGPMid(String gPMid) {
	GPMid = gPMid;
}



public String getCurr_project() {
	return Curr_project;
}



public void setCurr_project(String curr_project) {
	Curr_project = curr_project;
}



@Override
public String toString() {
	return "Employee [empid=" + empid + ", ename=" + ename + ", status=" + status + ", total_wage=" + total_wage
			+ ", numberOfDaysWork=" + numberOfDaysWork + ", GPMid=" + GPMid + ", Curr_project=" + Curr_project + "]";
}



	
	
}
