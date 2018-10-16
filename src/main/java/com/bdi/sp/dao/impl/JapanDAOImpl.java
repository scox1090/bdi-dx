package com.bdi.sp.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bdi.sp.dao.JapanDAO;
import com.bdi.sp.vo.Japan;

@Repository
public class JapanDAOImpl implements JapanDAO {

	@Autowired
	private SqlSession ss;
	
	@Override
	public List<Japan> getJapanList(Japan j) {
		// TODO Auto-generated method stub
		return ss.selectList("com.bdi.sp.JapanMapper.selectJapanList");
	}

	@Override
	public Japan getJapan(int jpnum) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.bdi.sp.JapanMapper.selectJapan",jpnum);
	}

	@Override
	public int insertJapan(Japan j) {
		
		return ss.insert("com.bdi.sp.JapanMapper.insertJapan",j);
	}

	@Override
	public int updateJapan(Japan j) {
		// TODO Auto-generated method stub
		return ss.update("com.bdi.sp.JapanMapper.updateJapan",j);
	}

	@Override
	public int deleteJapan(Japan j) {
		// TODO Auto-generated method stub
		return ss.delete("com.bdi.sp.JapanMapper.deleteJapan",j);
	}


}
