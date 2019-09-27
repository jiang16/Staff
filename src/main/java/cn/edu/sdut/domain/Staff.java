package cn.edu.sdut.domain;

public class Staff {

	private int s_id;
	private String name;
	private String sex;
	private String birth;
	private String degree;
	private String dept;
	private String position;
	private String entry;
	private float wage;
	private String contact;
	
	public Staff() {}
	public Staff(int s_id, String name, String sex, String birth, String degree, String dept, String position,
			String entry, float wage, String contact) {
		super();
		this.s_id = s_id;
		this.name = name;
		this.sex = sex;
		this.birth = birth;
		this.degree = degree;
		this.dept = dept;
		this.position = position;
		this.entry = entry;
		this.wage = wage;
		this.contact = contact;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
	public float getWage() {
		return wage;
	}
	public void setWage(float wage) {
		this.wage = wage;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
}
