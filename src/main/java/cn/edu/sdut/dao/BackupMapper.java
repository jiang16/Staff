package cn.edu.sdut.dao;

import java.util.List;

import cn.edu.sdut.domain.Backup;

public interface BackupMapper {
	public List<Backup> selectAll();
	public Backup selectBackup(int id);
	public int add(Backup backup);
	public int delete(int id);
}
