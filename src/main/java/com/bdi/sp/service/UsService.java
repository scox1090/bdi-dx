package com.bdi.sp.service;

import java.util.List;



import com.bdi.sp.vo.Us;



public interface UsService {

	public List<Us> getUsList(Us u);
	public Us  getUs(int usno);
	public int insertUs(Us  u);
	public int updateUs(Us  u);
	public int deleteUs(Us  u);
	public int login(Us u);
	public int idck(Us u);
}
