package com.bdi.sp.service;

import java.util.List;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bdi.sp.vo.Us;



public interface UsService {

	public List<Us> getUsList(Us u);
	public Us  getUs(int usno);
	public int insertUs(Us  u,HttpServletResponse response)throws Exception;
	public int updateUs(Us  u);
	public int deleteUs(Us  u);
	public int check_id(String usid, HttpServletResponse response)throws Exception;
	public int login(Us u);
}
