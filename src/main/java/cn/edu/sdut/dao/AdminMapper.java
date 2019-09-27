package cn.edu.sdut.dao;

import org.apache.ibatis.annotations.Param;

import cn.edu.sdut.domain.Admin;

public interface AdminMapper {
	public Admin select(Admin admin);
	public int update(@Param("oldPwd")String oldPsd, @Param("newPsd")String newPsd);
}
