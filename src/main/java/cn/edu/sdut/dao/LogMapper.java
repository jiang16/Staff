package cn.edu.sdut.dao;

import java.util.List;

import cn.edu.sdut.domain.Log;

public interface LogMapper {
	public List<Log> selectAll();
	public int insertLog(Log log);
	public int deleteOut();
}
