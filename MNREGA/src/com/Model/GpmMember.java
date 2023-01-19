package com.Model;

public class GpmMember {

private	String gpmID;
private String gname;
private String gpmpass;
private String bdoNo;
private String alloted_project;


public GpmMember() {
	super();
	
}


public GpmMember(String gpmID, String gname, String gpmpass, String bdoNo, String alloted_project) {
	super();
	this.gpmID = gpmID;
	this.gname = gname;
	this.gpmpass = gpmpass;
	this.bdoNo = bdoNo;
	this.alloted_project = alloted_project;
}


public String getGpmID() {
	return gpmID;
}


public void setGpmID(String gpmID) {
	this.gpmID = gpmID;
}


public String getGname() {
	return gname;
}


public void setGname(String gname) {
	this.gname = gname;
}


public String getGpmpass() {
	return gpmpass;
}


public void setGpmpass(String gpmpass) {
	this.gpmpass = gpmpass;
}


public String getBdoNo() {
	return bdoNo;
}


public void setBdoNo(String bdoNo) {
	this.bdoNo = bdoNo;
}


public String getAlloted_project() {
	return alloted_project;
}


public void setAlloted_project(String alloted_project) {
	this.alloted_project = alloted_project;
}


@Override
public String toString() {
	return "GpmMember [gpmID=" + gpmID + ", gname=" + gname + ", gpmpass=" + gpmpass + ", bdoNo=" + bdoNo
			+ ", alloted_project=" + alloted_project + "]";
}







	
}
