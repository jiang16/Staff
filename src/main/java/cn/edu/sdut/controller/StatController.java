package cn.edu.sdut.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sdut.service.StatService;


@Controller
public class StatController {
	@Autowired
	StatService statService;
	
	@GetMapping("/stats")
	public String stats() {
		return "stats";
	}
	
	@ResponseBody
	@GetMapping("/getData")
	public Map<String, Object> getData() {
		Map<String, Object> map = new HashMap<>();
		map.put("sum", statService.getSum());
		map.put("avgAge", statService.avgAge());
		map.put("avgWage", statService.avgWage());
		map.put("ageDist", statService.ageDist());
		map.put("wageDist", statService.wageDist());
		return map;
	}
}
