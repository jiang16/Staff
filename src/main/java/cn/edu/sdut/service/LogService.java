package cn.edu.sdut.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sdut.dao.LogMapper;
import cn.edu.sdut.domain.Log;
import cn.edu.sdut.util.IpAddrUtil;


@Service
public class LogService {
	@Autowired
	LogMapper logMapper;
	
	public List<Log> getList() {
		return logMapper.selectAll();
	}
	
	//记录日志，供其他服务调用
	public int addLog(HttpServletRequest request, String opt) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formatter.format(new Date());
		String ip = IpAddrUtil.getIpAddr(request);
		Log log = new Log(0, time, ip, opt);
		return logMapper.insertLog(log);
	}
	
	public int cleanLog() {
		return logMapper.deleteOut();
	}
}
