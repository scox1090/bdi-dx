package com.bdi.sp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdi.sp.service.UsService;
import com.bdi.sp.vo.Us;


@Controller
public class UsController {
	private static final Logger logger = LoggerFactory.getLogger(UsController.class);
	@Autowired
	private UsService us;
	
	@RequestMapping(value="/users/login",method=RequestMethod.POST)
	public @ResponseBody Map<String,String> login(@RequestBody Us u){
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("login", "fail");
		rMap.put("msg","아이디 및 비밀번호를 확인하세요");
		if(us.login(u)==0) {
			return rMap;
		}
		
		if(us.login(u)==1) {
				rMap.put("login", "success");
				rMap.put("msg", "로그인 되었습니다.");
			}
		return rMap;
	}
	@RequestMapping(value="/users/idck",method=RequestMethod.POST)
	public @ResponseBody Map<String,String> idck(@RequestBody Us u){
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("idck", "success");
		rMap.put("msg","아이디를 만들 수 있습니다.");
		if(us.idck(u)==0) {
			return rMap;
		}
		
		if(us.idck(u)==1) {
				rMap.put("idck", "fail");
				rMap.put("msg", ".이미 있는 아이디입니다.");
			}
		return rMap;
	}
	
	@RequestMapping (value="/users", method=RequestMethod.GET)
		public @ResponseBody List<Us> getUsList(@ModelAttribute Us u){
		
			return us.getUsList(null);
		}
	
	@RequestMapping (value="/users/{usno}", method=RequestMethod.GET)
	public @ResponseBody Us getUsOne(@PathVariable Integer usno){
		return us.getUs(usno);
	}
	
	

	@RequestMapping (value="/users", method=RequestMethod.POST)
	public @ResponseBody int insertUs(@RequestBody Us u){

		logger.debug("insertuser=>{}",u);
		return us.insertUs(u);
	}
	
	@RequestMapping (value="/users/{usno}", method=RequestMethod.PUT)
	public @ResponseBody int updateUs(@RequestBody Us u, @PathVariable Integer usno){
		u.setUsno(usno);
		logger.debug("updateuser=>{}",u);
		return us.updateUs(u);
	}
	
	@RequestMapping (value="/users/{usno}", method=RequestMethod.DELETE)
	public @ResponseBody int deleteUs(@RequestBody Us u, @PathVariable Integer usno){
		u.setUsno(usno);
		logger.debug("deleteuser=>{}",u);
		return us.deleteUs(u);
	}

}
