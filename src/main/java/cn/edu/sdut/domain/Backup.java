package cn.edu.sdut.domain;

public class Backup {

	private int id;
	private String time;
	private String file;
	private String path;
	private String info;
	
	public Backup() {}
	
	public Backup(int id, String time, String file, String path, String info) {
		super();
		this.id = id;
		this.time = time;
		this.file = file;
		this.path = path;
		this.info = info;
	}
	public int getId() {
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
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
