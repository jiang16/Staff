package cn.edu.sdut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sdut.dao.StaffMapper;
import cn.edu.sdut.domain.Staff;

@Service
public class StaffService {
	@Autowired
	StaffMapper staffMapper;
	
	public List<Staff> getList() {
		return staffMapper.selectAll();
	}
	
	public Staff getStaff(int s_id) {
		Staff staff = staffMapper.selectStaff(s_id);
		String[] tmp = staff.getBirth().split("-");
		staff.setBirth(tmp[1] + "/" + tmp[2] + "/" + tmp[0]);
		return staff;
	}
	
	public int addStaff(String name, String sex, String birth, String degree, String dept, String position,
			String entry, String wage, String contact) {
		if(birth.contains("/")) {
			birth = changeDate(birth);
		}
		Staff staff = new Staff(0, name, sex, birth, degree, dept, position, entry, Float.parseFloat(wage), contact);
		return staffMapper.add(staff);
	}
	
	public int updateStaff(String s_id, String name, String sex, String birth, String degree, String dept,
			String position, String entry, String wage, String contact) {
		if(birth.contains("/")) {
			birth = changeDate(birth);
		}
		Staff staff = new Staff(Integer.parseInt(s_id), name, sex, birth, degree, dept, position, entry, Float.parseFloat(wage), contact);
		return staffMapper.update(staff);
	}
	
	public int deleteStaff(int s_id) {
		return staffMapper.delete(s_id);
	}
	
	private String changeDate(String str) {
		String res;
		String[] tmp = str.split("/");
		res = tmp[2] + "-" + tmp[0] + "-" + tmp[1];
		return res;
	}
}
