package com.nuri.lguplus.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nuri.lguplus.domain.SampleDomain;
import com.nuri.lguplus.mvc.service.SampleEntityService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "sampleEntities")
public class SampleEntityController {
	
	@Autowired
	private SampleEntityService sampleEntityService;
	
//	@Autowired
//	private RedisTemplate<String, Object> redisTemplate;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<SampleDomain> getUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return this.sampleEntityService.getList();
	}
	
	
	@RequestMapping(value = "/redistest", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public List<SampleDomain> redistest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SampleDomain se = new SampleDomain();
		se.setUserId("test");
		se.setUserName("pjjtest");
//		redisTemplate.opsForValue().set("sample", se);
		
//		 Long df = (Long)redisTemplate.opsForValue().get("sample");
		
		return this.sampleEntityService.getList();
	}
	
}
