package cn.edu.sdut.dao;

import java.util.List;

import cn.edu.sdut.domain.Dept;;

public interface DeptMapper {
	public List<Dept> selectAll();
	public List<String> getDept();
	public Dept selectDept(String d_id);
	public int add(Dept dept);
	public int update(Dept dept);
	public int delete(String d_id);
}
