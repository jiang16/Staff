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
import cn.edu.sdut.service.StaffService;

@Controller
public class StaffController {
	@Autowired
	StaffService staffService;
	@Autowired
	DeptService deptService;
	@Autowired
	LogService logService;
	
	@GetMapping("/staff")
	public String staff(ModelMap modelMap) {
		modelMap.put("list", staffService.getList());
		return "staff";
	}

	@GetMapping("/staff/add")
	public String add(ModelMap modelMap) {
		modelMap.put("depts", deptService.getDepts());
		return "addStaff";
	}
	
	@ResponseBody
	@PostMapping("/addStaff")
	public String addStaff(HttpServletRequest request) {
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birth");
		String degree = request.getParameter("degree");
		String dept = request.getParameter("dept");
		String position = request.getParameter("position");
		String entry = request.getParameter("entry");
		String wage = request.getParameter("wage");
		String contact = request.getParameter("contact");
		if(staffService.addStaff(name, sex, birth, degree, dept, position, entry, wage, contact) == 0) {
			logService.addLog(request, "添加员工失败");
			return "no";
		}
		logService.addLog(request, "添加一位名为" + name + "的员工");
		return "ok";
	}
	
	@GetMapping("/staff/edit")
	public String editStaff(@RequestParam("s_id") String s_id, ModelMap modelMap) {
		modelMap.put("staff", staffService.getStaff(Integer.parseInt(s_id)));
		modelMap.put("depts", deptService.getDepts());
		return "editStaff";
	}
	
	@ResponseBody
	@PostMapping("/editStaff")
	public String editStaff(HttpServletRequest request) {
		String s_id = request.getParameter("s_id"); 
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birth");
		String degree = request.getParameter("degree");
		String dept = request.getParameter("dept");
		String position = request.getParameter("position");
		String entry = request.getParameter("entry");
		String wage = request.getParameter("wage");
		String contact = request.getParameter("contact");
		if(staffService.updateStaff(s_id, name, sex, birth, degree, dept, position, entry, wage, contact) == 0) {
			logService.addLog(request, "保存员工信息失败");
			return "no";
		}
		logService.addLog(request, "修改一位名为" + name + "的员工的信息");
		return "ok";
	}
	
	@GetMapping("/deleteStaff")
	public String deleteStaff(@RequestParam("s_id") String s_id, HttpServletRequest request) {
		staffService.deleteStaff(Integer.parseInt(s_id));
		logService.addLog(request, "删除工号为" + s_id + "的员工");
		return "redirect:staff";
	}
}
