package com.bdi.sp.dao;

import java.util.List;

import com.bdi.sp.vo.Japan;

public interface JapanDAO {

	public List<Japan> getJapanList(Japan j);
	public Japan getJapan(int jpnum);
	public int insertJapan(Japan j);
	public int updateJapan(Japan j);
	public int deleteJapan(Japan j);
}
