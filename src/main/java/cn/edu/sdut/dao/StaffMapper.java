package cn.edu.sdut.dao;

import java.util.List;
import cn.edu.sdut.domain.Staff;


public interface StaffMapper {
	public List<Staff> selectAll();
	public Staff selectStaff(int s_id);
	public int add(Staff staff);
	public int update(Staff staff);
	public int delete(int s_id);
	
	public int getSum();
	public int avgAge();
	public float avgWage();
	public int[] getAge();
	public float[] getWage();
}
