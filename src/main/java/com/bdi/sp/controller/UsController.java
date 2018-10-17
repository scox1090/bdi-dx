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
		public @ResponseBody List<Us> getJapanList(@ModelAttribute Us u){
			return us.getUsList(null);
		}
	
	@RequestMapping (value="/users/{usno}", method=RequestMethod.GET)
	public @ResponseBody Us getUsOne(@PathVariable Integer usno){
		return us.getUs(usno);
	}
	
	@RequestMapping (value="/users/{usno}", method=RequestMethod.POST)
	public @ResponseBody int insertJapan(@ModelAttribute Us u, @PathVariable Integer usno){
		logger.debug("insertjapan=>{}",u);
		return us.insertUs(u);
	}
	
	@RequestMapping (value="/users/{usno}", method=RequestMethod.PUT)
	public @ResponseBody int updateJapan(@RequestBody Us u, @PathVariable Integer usno){
		u.setusno(usno);
		logger.debug("updatejapan=>{}",u);
		return us.updateUs(u);
	}
	
	@RequestMapping (value="/users/{usno}", method=RequestMethod.DELETE)
	public @ResponseBody int deleteJapan(@RequestBody Us u, @PathVariable Integer usno){
		u.setusno(usno);
		logger.debug("deletejapan=>{}",u);
		return us.deleteUs(u);
	}

}
