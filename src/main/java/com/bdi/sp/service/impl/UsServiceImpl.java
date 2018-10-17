package com.bdi.sp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdi.sp.dao.UsDAO;
import com.bdi.sp.service.UsService;
import com.bdi.sp.vo.Us;

@Service
public class UsServiceImpl implements UsService {

	@Autowired
	private UsDAO udao;
	
	@Override
	public List<Us> getUsList(Us u) {
		// TODO Auto-generated method stub
		return udao.getUsList(u);
	}

	@Override
	public Us getUs(int usno) {
		// TODO Auto-generated method stub
		return udao.getUs(usno);
	}

	@Override
	public int insertUs(Us u) {
		// TODO Auto-generated method stub
		return udao.insertUs(u);
	}

	@Override
	public int updateUs(Us u) {
		// TODO Auto-generated method stub
		return udao.updateUs(u);
	}

	@Override
	public int deleteUs(Us u) {
		// TODO Auto-generated method stub
		return udao.deleteUs(u);
	}

}
