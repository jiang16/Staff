package cn.edu.sdut.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sdut.service.AdminService;
import cn.edu.sdut.service.LogService;

@Controller
public class AdminController {
	@Autowired
	AdminService adminService;
	@Autowired
	LogService logService;
	
	@ResponseBody
	@PostMapping(value = "/login")
	public String login(HttpServletRequest request) {
		String user = request.getParameter("user");
		String psd = request.getParameter("psd");
		if(adminService.login(user, psd)) {
			logService.addLog(request, "登录成功");
			request.getSession().setAttribute("user", "admin");
			return "ok";
		}
		logService.addLog(request, "登录失败");
		return "no";
	}
	
	@GetMapping(value = "/logout")
	public String logout() {
		return "login";
	}
	
	@ResponseBody
	@PostMapping(value = "/updatePsd")
	public String updatePsd(HttpServletRequest request) {
		String oldPsd = request.getParameter("oldPsd");
		String newPsd = request.getParameter("newPsd");
		if(adminService.updatePsd(oldPsd, newPsd) == 1) {
			logService.addLog(request, "修改密码");
			return "ok";
		}
		logService.addLog(request, "修改密码失败");
		return "no";
	}
}
