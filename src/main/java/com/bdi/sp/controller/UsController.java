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

import com.bdi.sp.service.UsService;
import com.bdi.sp.vo.Us;



@Controller
public class UsController {
	private static final Logger logger = LoggerFactory.getLogger(UsController.class);
	@Autowired
	private UsService us;
	
	@RequestMapping (value="/users", method=RequestMethod.GET)
		public @ResponseBody List<Us> getUsList(@ModelAttribute Us u){
		
			return us.getUsList(null);
		}
	
	@RequestMapping (value="/users/{usno}", method=RequestMethod.GET)
	public @ResponseBody Us getUsOne(@PathVariable Integer usno){
		return us.getUs(usno);
	}
	
	@RequestMapping (value="/users/{usno}", method=RequestMethod.POST)
	public @ResponseBody int insertUs(@ModelAttribute Us u, @PathVariable Integer usno){
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
