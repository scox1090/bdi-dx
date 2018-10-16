package com.bdi.sp.dao;

import java.util.List;

import com.bdi.sp.vo.DepartInfo;

public interface DepartInfoDAO {

	public List<DepartInfo> selectDepartInfoList(DepartInfo di);
	public DepartInfo selectDepartInfo(int dino);
	public int insertDepartInfo(DepartInfo di);
	public int updateDepartInfo(DepartInfo di);
	public int deleteDepartInfo(DepartInfo di);
}
