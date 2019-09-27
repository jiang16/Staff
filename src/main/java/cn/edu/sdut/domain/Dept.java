package cn.edu.sdut.domain;

public class Dept {

	private String d_id;
	private String name;
	private String manager;
	private String front;
	private String found;
	
	public Dept() {}
	public Dept(String d_id, String name, String manager, String front, String found) {
		super();
		this.d_id = d_id;
		this.name = name;
		this.manager = manager;
		this.front = front;
		this.found = found;
	}
	public String getD_id() {
		return d_id;
	}
	public void setD_id(String d_id) {
		this.d_id = d_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getFront() {
		return front;
	}
	public void setFront(String front) {
		this.front = front;
	}
	public String getFound() {
		return found;
	}
	public void setFound(String found) {
		this.found = found;
	}
}
