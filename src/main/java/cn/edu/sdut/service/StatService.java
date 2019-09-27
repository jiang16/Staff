package cn.edu.sdut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sdut.dao.StaffMapper;


@Service
public class StatService {
	@Autowired
	StaffMapper staffMapper;
	
	public int getSum() {
		return staffMapper.getSum();
	}
	
	public int avgAge() {
		return staffMapper.avgAge();
	}
	
	public float avgWage() {
		return staffMapper.avgWage();
	}
	
	public int[] ageDist() {
		int[] ages = staffMapper.getAge();
		int[] age = new int[4];
		for(int i = 0; i < ages.length; i++) {
			int a = ages[i];
			if(a >= 20 && a < 30) {
				age[0] += 1;
			}else if(a >= 30 && a < 40) {
				age[1] += 1;
			}else if(a >= 40 && a < 50) {
				age[2] += 1;
			}else {
				age[3] += 1;
			}
		}
		return age;
	}
	
	public int[] wageDist() {
		float[] wages = staffMapper.getWage();
		int[] wage = new int[5];
		for(int i = 0; i < wages.length; i++) {
			float w = wages[i];
			if(w <= 5000) {
				wage[0] += 1;
			}else if(w >= 5000 && w < 10000) {
				wage[1] += 1;
			}else if(w >= 10000 && w < 15000) {
				wage[2] += 1;
			}else if(w >= 15000 && w < 20000) {
				wage[3] += 1;
			}else {
				wage[4] += 1;
			}
		}
		return wage;
	}
}
