package cn.edu.sdut.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sdut.service.LogService;


@Controller
public class LogController {
	@Autowired
	LogService logService;
	
	@GetMapping("/log")
	public String log(ModelMap modelMap) {
		modelMap.put("list", logService.getList());
		return "log";
	}
	
	@ResponseBody
	@GetMapping("/cleanLog")
	public void cleanLog(HttpServletRequest request) {
		logService.addLog(request, "清理日志");
		logService.cleanLog();
	}
}
