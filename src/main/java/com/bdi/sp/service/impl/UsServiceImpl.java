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
		rMap.put("msg","수정 실패.");
		int cnt = udao.updateUs(u);
		if(cnt==0) {
			return rMap;
		}
		
		if(cnt==1) {
				rMap.put("update", "success");
				rMap.put("msg", "수정 성공.");
			}
		return rMap;
	}

	@Override
	public Map<String,String> deleteUs(Us u) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("delete", "fail");
		rMap.put("msg","삭제 실패.");
		int cnt = udao.deleteUs(u);
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
	public Map<String,String> login(Us u) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("login", "fail");
		rMap.put("msg","아이디 및 비밀번호를 확인하세요.");
		if(udao.login(u)==0) {
			return rMap;
		}
		
		if(udao.login(u)==1) {
				rMap.put("login", "success");
				rMap.put("msg", "로그인 되었습니다.");
			}
		return rMap;
	}

	
	@Override
	public Map<String,String> idck(Us u) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("idck", "success");
		rMap.put("msg","아이디를 만들 수 있습니다.");
		String id = udao.idck(u);
		String id2 = u.getUsid();
		if(id==null) {
			rMap.put("value", id2);
			return rMap;
		}
		
		if(id!=u.getUsid()) {
				rMap.put("idck", "fail");
				rMap.put("msg", "이미 있는 아이디입니다.");
		}
		return rMap;
	}

	
}
