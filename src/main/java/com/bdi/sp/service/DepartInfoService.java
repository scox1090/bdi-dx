package com.bdi.sp.service;

import java.util.List;

import com.bdi.sp.vo.DepartInfo;

public interface DepartInfoService {

	public List<DepartInfo> selectDepartInfoList(DepartInfo di);
	public DepartInfo selectDepartInfo(int dino);
	public int insertDepartInfo(DepartInfo di);
	public int updateDepartInfo(DepartInfo di);
	public int deleteDepartInfo(DepartInfo di);
}
