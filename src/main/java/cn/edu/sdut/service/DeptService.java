package cn.edu.sdut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sdut.dao.DeptMapper;
import cn.edu.sdut.domain.Dept;


@Service
public class DeptService {
	@Autowired
	DeptMapper deptMapper;
	
	public List<Dept> getList() {
		return deptMapper.selectAll();
	}
	
	//获取所有部门名称列表
	public List<String> getDepts() {
		return deptMapper.getDept();
	}
	
	public Dept getDept(String d_id) {
		return deptMapper.selectDept(d_id);
	}
	
	public int addDept(String d_id, String name, String manager, String front, String found) {
		Dept dept = new Dept(d_id, name, manager, front, found);
		return deptMapper.add(dept);
	}
	
	public int updateDept(String d_id, String name, String manager, String front, String found) {
		Dept dept = new Dept(d_id, name, manager, front, found);
		return deptMapper.update(dept);
	}
	
	public int deleteDept(String d_id) {
		return deptMapper.delete(d_id);
	}
}
