package com.bdi.sp.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bdi.sp.dao.DepartInfoDAO;
import com.bdi.sp.vo.DepartInfo;

@Repository
public class DepartInfoDAOImpl implements DepartInfoDAO{

	@Autowired
	private SqlSession ss;
	
	@Override
	public List<DepartInfo> selectDepartInfoList(DepartInfo di) {
		// TODO Auto-generated method stub
		return ss.selectList("com.bdi.sp.DepartMapper.selectDepartInfoList");
	}

	@Override
	public DepartInfo selectDepartInfo(int dino) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.bdi.sp.DepartMapper.selectDepartInfo",dino);
	}

	@Override
	public int insertDepartInfo(DepartInfo di) {
		// TODO Auto-generated method stub
		return ss.insert("com.bdi.sp.DepartMapper.insertDepartInfo",di);
	}

	@Override
	public int updateDepartInfo(DepartInfo di) {
		// TODO Auto-generated method stub
		return ss.update("com.bdi.sp.DepartMapper.updateDepartInfo",di);
	}

	@Override
	public int deleteDepartInfo(DepartInfo di) {
		// TODO Auto-generated method stub
		return ss.delete("com.bdi.sp.DepartMapper.deleteJapan",di);
	}

}
