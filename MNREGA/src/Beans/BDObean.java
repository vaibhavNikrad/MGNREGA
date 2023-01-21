package Beans;

public class BDObean {

	String bdoID;
	String name;
	String username;
	String password;
	
	public BDObean(String bdoID, String name, String username, String password) {
		super();
		this.bdoID = bdoID;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public String getBdoID() {
		return bdoID;
	}

	public void setBdoID(String bdoID) {
		this.bdoID = bdoID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "BDObean [bdoID=" + bdoID + ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}
	
}
