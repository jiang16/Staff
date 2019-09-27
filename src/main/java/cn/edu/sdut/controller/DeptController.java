package cn.edu.sdut.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sdut.service.DeptService;
import cn.edu.sdut.service.LogService;


@Controller
public class DeptController {
	@Autowired
	DeptService deptService;
	@Autowired
	LogService logService;
	
	@GetMapping("/dept")
	public String dept(ModelMap modelMap) {
		modelMap.put("list", deptService.getList());
		return "dept";
	}

	@GetMapping("/dept/add")
	public String add(ModelMap modelMap) {
		modelMap.put("depts", deptService.getDepts());
		return "addDept";
	}
	
	@ResponseBody
	@PostMapping("/addDept")
	public String addDept(HttpServletRequest request) {
		String d_id = request.getParameter("d_id");
		String name = request.getParameter("name");
		String manager = request.getParameter("manager");
		String front = request.getParameter("front");
		String found = request.getParameter("found");
		if(deptService.addDept(d_id, name, manager, front, found) == 0) {
			logService.addLog(request, "添加部门失败");
			return "no";
		}
		logService.addLog(request, "添加一个名为" + name + "的部门");
		return "ok";
	}
	
	@GetMapping("/dept/edit")
	public String edit(@RequestParam("d_id") String d_id, ModelMap modelMap) {
		modelMap.put("depts", deptService.getDepts());
		modelMap.put("dept", deptService.getDept(d_id));
		return "editDept";
	}
	
	@ResponseBody
	@PostMapping("/editDept")
	public String editDept(HttpServletRequest request) {
		String d_id = request.getParameter("d_id");
		System.out.println(d_id);
		String name = request.getParameter("name");
		String manager = request.getParameter("manager");
		String front = request.getParameter("front");
		String found = request.getParameter("found");
		if(deptService.updateDept(d_id, name, manager, front, found) == 0) {
			logService.addLog(request, "保存部门信息失败");
			return "no";
		}
		logService.addLog(request, "修改一个名为" + name + "的部门的信息");
		return "ok";
	}
	
	@GetMapping("/deleteDept")
	public String deleteDept(@RequestParam("d_id") String d_id, HttpServletRequest request ) {
		deptService.deleteDept(d_id);
		logService.addLog(request, "删除编号为" + d_id + "的部门");
		return "redirct:dept";
	}
}
