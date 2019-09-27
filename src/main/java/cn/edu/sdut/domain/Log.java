package cn.edu.sdut.domain;

public class Log {

	private long id;
	private String time;
	private String ip;
	private String opt;
	
	public Log() {}
	public Log(long id, String time, String ip, String opt) {
		super();
		this.id = id;
		this.time = time;
		this.ip = ip;
		this.opt = opt;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
	}
}
