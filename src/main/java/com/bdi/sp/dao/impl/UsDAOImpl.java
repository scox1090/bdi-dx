package com.bdi.sp.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bdi.sp.dao.UsDAO;
import com.bdi.sp.vo.Us;

@Repository
public class UsDAOImpl implements UsDAO {

	@Autowired
	private SqlSession ss;
	
	@Override
	public List<Us> getUsList(Us u) {
		// TODO Auto-generated method stub
		return ss.selectList("com.bdi.sp.vo.Us.selectUsList");
	}

	@Override
	public Us getUs(int usno) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.bdi.sp.vo.Us.selectUs",usno);
	}

	@Override
	public int insertUs(Us u) {
		// TODO Auto-generated method stub
		return ss.insert("com.bdi.sp.vo.Us.insertUs",u);
	}

	@Override
	public int updateUs(Us u) {
		// TODO Auto-generated method stub
		return ss.update("com.bdi.sp.vo.Us.updateUs",u);
	}

	@Override
	public int deleteUs(Us u) {
		// TODO Auto-generated method stub
		return ss.delete("com.bdi.sp.vo.Us.deleteUs",u);
	}

}
