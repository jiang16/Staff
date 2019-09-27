package cn.edu.sdut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sdut.dao.AdminMapper;
import cn.edu.sdut.domain.Admin;

@Service
public class AdminService {
	@Autowired
	AdminMapper adminMapper;
	
	public boolean login(String user, String psd) {
		Admin admin = adminMapper.select(new Admin(user, psd));
		if(admin == null) return false;
		return true;
	}
	
	public int updatePsd(String oldPsd, String newPsd) {
		return adminMapper.update(oldPsd, newPsd);
	}
}
