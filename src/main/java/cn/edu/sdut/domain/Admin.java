package cn.edu.sdut.domain;

public class Admin {

	private String user;
	private String psd;
	
	public Admin() {}
	public Admin(String user, String psd) {
		super();
		this.user = user;
		this.psd = psd;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
}
