package com.bdi.sp.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	public Map<String, String> insertUs(Us u) {
		
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("insert", "fail");
		rMap.put("msg","회원가입 실패.");
		int cnt = udao.insertUs(u);
		if(cnt==0) {
			return rMap;
		}
		
		if(cnt==1) {
				rMap.put("insert", "success");
				rMap.put("msg", "회원가입 성공.");
			}
		return rMap;	
		
} 
		
	

	@Override
	public Map<String,String> updateUs(Us u) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("update", "fail");
		rMap.put("msg","삭제실패.");
		int cnt = udao.insertUs(u);
		if(cnt==0) {
			return rMap;
		}
		
		if(cnt==1) {
				rMap.put("update", "success");
				rMap.put("msg", "삭제성공.");
			}
		return rMap;
	}

	@Override
	public Map<String,String> deleteUs(Us u) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("delete", "fail");
		rMap.put("msg","삭제 실패.");
		int cnt = udao.insertUs(u);
		if(cnt==0) {
			return rMap;
		}
		
		if(cnt==1) {
				rMap.put("delete", "success");
				rMap.put("msg", "삭제 성공.");
			}
		return rMap;
	}



	@Override
	public int login(Us u) {
		
		return udao.login(u);
	}


	@Override
	public int idck(Us u) {
		// TODO Auto-generated method stub
		return udao.idck(u);
	}

	
}
