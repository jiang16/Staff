package cn.edu.sdut.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.sdut.dao.BackupMapper;
import cn.edu.sdut.domain.Backup;


@Service
public class BackupService {
	@Autowired
	BackupMapper backupMapper;
	
	public List<Backup> getList() {
		return backupMapper.selectAll();
	}
	
	public int addBackup(String file, String path, String info, String table) {
		String fname = file + ".sql";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = formatter.format(new Date());
		Backup backup = new Backup(1, time, fname, path, info);
		//生成相应的备份文件
		String obj = "";
		switch (table) {
		case "1":
			obj = "project";
			break;
		case "2":
			obj = "project admin";
			break;
		case "3":
			obj = "project staff";
			break;
		case "4":
			obj = "project dept";
			break;
		case "5":
			obj = "project log";
			break;
		}
		String[] cmd = {
				"/bin/sh",
				"-c",
				"/usr/bin/mysqldump -ujiang -pjiangxy " + obj + " > " + path + "/" + fname
		};
		int status = exec(cmd);
		if(status == 0) {
			backupMapper.add(backup);
		}
		return status;
	}
	
	public int deleteBackup(int id) {
		Backup backup = backupMapper.selectBackup(id);
		String path = backup.getPath();
		String file = backup.getFile();
		//删除相应的备份文件
		String[] cmd = {"/bin/rm", "-f", path + "/" + file};
		int status = exec(cmd);
		if(status == 0) {
			backupMapper.delete(id);
		}
		return status;
	}
	
	//执行shell命令
	private int exec(String[] cmd) {
		Process process;
		try {
			process = Runtime.getRuntime().exec(cmd);
			int status = process.waitFor();
			if(status != 0) return status;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}
}
