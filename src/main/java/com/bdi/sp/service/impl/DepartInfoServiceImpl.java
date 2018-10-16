package com.bdi.sp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdi.sp.dao.DepartInfoDAO;
import com.bdi.sp.service.DepartInfoService;
import com.bdi.sp.vo.DepartInfo;

@Service
public class DepartInfoServiceImpl implements DepartInfoService{

	@Autowired
	private DepartInfoDAO ddao;
	
	@Override
	public List<DepartInfo> selectDepartInfoList(DepartInfo di) {
		// TODO Auto-generated method stub
		return ddao.selectDepartInfoList(di);
	}

	@Override
	public DepartInfo selectDepartInfo(int dino) {
		// TODO Auto-generated method stub
		return ddao.selectDepartInfo(dino);
	}

	@Override
	public int insertDepartInfo(DepartInfo di) {
		// TODO Auto-generated method stub
		return ddao.insertDepartInfo(di);
	}

	@Override
	public int updateDepartInfo(DepartInfo di) {
		// TODO Auto-generated method stub
		return ddao.updateDepartInfo(di);
	}

	@Override
	public int deleteDepartInfo(DepartInfo di) {
		// TODO Auto-generated method stub
		return ddao.deleteDepartInfo(di);
	}

}
