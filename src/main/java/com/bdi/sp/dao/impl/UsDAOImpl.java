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
		return ss.selectList("com.bdi.sp.UsMapper.selectUsList");
	}

	@Override
	public Us getUs(int usno) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.bdi.sp.UsMapper.selectUs",usno);
	}

	@Override
	public int insertUs(Us u) {
		// TODO Auto-generated method stub
		return ss.insert("com.bdi.sp.UsMapper.insertUs",u);
	}

	@Override
	public int updateUs(Us u) {
		// TODO Auto-generated method stub
		return ss.update("com.bdi.sp.UsMapper.updateUs",u);
	}

	@Override
	public int deleteUs(Us u) {
		// TODO Auto-generated method stub
		return ss.delete("com.bdi.sp.UsMapper.deleteUs",u);
	}

	
	@Override
	public int login(Us u) {
		int cnt = 0;
		if(ss.selectOne("com.bdi.sp.UsMapper.login",u)!=null) {
			cnt++;
		}
		return cnt;
	}

	@Override
	public int idck(Us u) {
		int cnt = 0;
		if(ss.selectOne("com.bdi.sp.UsMapper.idck",u)!=null) {
			cnt++;
		}
		return cnt;
	}

}
