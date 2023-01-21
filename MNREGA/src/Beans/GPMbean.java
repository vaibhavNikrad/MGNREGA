package Beans;

public class GPMbean {

	String gpmID;
	String gpmName;
	String gpmUsername;
	String gpmPassword;
	String bdoSupervise;
    String pojAllot;
    
	public GPMbean(String gpmID, String gpmName, String gpmUsername, String gpmPassword, String bdoSupervise,
			String pojAllot) {
		super();
		this.gpmID = gpmID;
		this.gpmName = gpmName;
		this.gpmUsername = gpmUsername;
		this.gpmPassword = gpmPassword;
		this.bdoSupervise = bdoSupervise;
		this.pojAllot = pojAllot;
	}

	public String getGpmID() {
		return gpmID;
	}

	public void setGpmID(String gpmID) {
		this.gpmID = gpmID;
	}

	public String getGpmName() {
		return gpmName;
	}

	public void setGpmName(String gpmName) {
		this.gpmName = gpmName;
	}

	public String getGpmUsername() {
		return gpmUsername;
	}

	public void setGpmUsername(String gpmUsername) {
		this.gpmUsername = gpmUsername;
	}

	public String getGpmPassword() {
		return gpmPassword;
	}

	public void setGpmPassword(String gpmPassword) {
		this.gpmPassword = gpmPassword;
	}

	public String getBdoSupervise() {
		return bdoSupervise;
	}

	public void setBdoSupervise(String bdoSupervise) {
		this.bdoSupervise = bdoSupervise;
	}

	public String getPojAllot() {
		return pojAllot;
	}

	public void setPojAllot(String pojAllot) {
		this.pojAllot = pojAllot;
	}

	@Override
	public String toString() {
		return "gpmID: " + gpmID + "\n" +
				"gpmName: " + gpmName +  "\n" +
				"gpmUsername: " + gpmUsername +  "\n" +
				"gpmPassword: "+ gpmPassword +  "\n" +
				"bdoSupervise: " + bdoSupervise +  "\n" +
				"pojAllot: " + pojAllot +  "\n" +
				"--------------------------------------";
	}
    
    
}
