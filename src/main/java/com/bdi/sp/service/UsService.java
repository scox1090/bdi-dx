package com.bdi.sp.service;

import java.util.List;
import java.util.Map;

import com.bdi.sp.vo.Us;



public interface UsService {

	public List<Us> getUsList(Us u);
	public Us  getUs(int usno);
	public Map<String,String> insertUs(Us  u);
	public Map<String,String> updateUs(Us  u);
	public Map<String,String> deleteUs(Us  u);
	public Map<String,String> login(Us u);
	public Map<String,String> idck(Us u);
}
