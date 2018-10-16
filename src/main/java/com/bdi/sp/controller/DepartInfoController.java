package com.bdi.sp.controller;

import java.util.List;

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

import com.bdi.sp.service.DepartInfoService;
import com.bdi.sp.vo.DepartInfo;

@Controller
public class DepartInfoController {

	private static final Logger logger = LoggerFactory.getLogger(JapanController.class);
	
	@Autowired
	private DepartInfoService ds;
	
	
	@RequestMapping(value="/departs", method=RequestMethod.GET)
	public @ResponseBody List<DepartInfo> selectDepartInfoList(@ModelAttribute DepartInfo di){
		return ds.selectDepartInfoList(null);
	}
	
	
	@RequestMapping(value="/departs/{dino}", method=RequestMethod.GET)
	public @ResponseBody DepartInfo selectDepartInfo(@ModelAttribute DepartInfo di,@PathVariable Integer dino){
		return ds.selectDepartInfo(dino);
	}
	
	
	@RequestMapping(value="/departs", method=RequestMethod.POST)
	public @ResponseBody int insertDepartInfo(@RequestBody DepartInfo di){
		logger.debug("insert=>{}",di);
		return ds.insertDepartInfo(di);
	}
	
	
	@RequestMapping(value="/departs/{dino}", method=RequestMethod.PUT)
	public @ResponseBody int updateDepartInfo(@RequestBody DepartInfo di,@PathVariable Integer dino){
		logger.debug("update=>{}",di);
		return ds.updateDepartInfo(di);
	}
	
	
	@RequestMapping(value="/departs/{dino}", method=RequestMethod.DELETE)
	public @ResponseBody int deleteDepartInfo(@RequestBody DepartInfo di,@PathVariable Integer dino){
		logger.debug("delete=>{}",di);
		return ds.deleteDepartInfo(di);
	}
}
