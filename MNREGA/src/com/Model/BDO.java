package com.Model;

public class BDO {

	
	private int bdoid;
	private String username;
	private String password;
	
	public BDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BDO(int bdoid, String username, String password) {
		super();
		this.bdoid = bdoid;
		this.username = username;
		this.password = password;
	}

	public int getBdoid() {
		return bdoid;
	}

	public void setBdoid(int bdoid) {
		this.bdoid = bdoid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "BDO [bdoid=" + bdoid + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
}
