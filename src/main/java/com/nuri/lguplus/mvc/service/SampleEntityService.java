package com.nuri.lguplus.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuri.lguplus.domain.SampleDomain;
import com.nuri.lguplus.repository.mybatis.SampleEntityMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SampleEntityService {
	
	@Autowired
	private SampleEntityMapper sampleEntityMapper;
	
	
	public List<SampleDomain> getList() {
		log.info("SampleEntityService.getList");
		return sampleEntityMapper.list();
	}
	
}
	
