package cn.edu.sdut.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sdut.service.BackupService;
import cn.edu.sdut.service.LogService;


@Controller
public class BackupController {
	@Autowired
	BackupService backupService;
	
	@Autowired
	LogService logService;
	
	@GetMapping("/backup")
	public String backup(ModelMap modelMap) {
		modelMap.put("list", backupService.getList());
		return "backup";
	}
	
	@ResponseBody
	@PostMapping("/addBackup")
	public String addBackup(HttpServletRequest request) {
		String file = request.getParameter("file");
		String path = request.getParameter("path");
		String info = request.getParameter("info");
		String table = request.getParameter("table");
		if(backupService.addBackup(file, path, info, table) != 0) {
			logService.addLog(request, "添加备份失败");
			return "no";
		}
		logService.addLog(request, "添加备份");
		return "ok";
	}
	
	@ResponseBody
	@GetMapping("/deleteBackup")
	public String deleteBackup(@RequestParam("id") String id, HttpServletRequest request) {
		if(backupService.deleteBackup(Integer.parseInt(id)) != 0) {
			logService.addLog(request, "删除备份失败");
			return "no";
		}
		logService.addLog(request, "删除备份");
		return "ok";
	}
}
