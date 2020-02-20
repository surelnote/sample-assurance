package com.nuri.lguplus.repository.mybatis;

import java.util.List;

import com.nuri.lguplus.domain.SampleDomain;

public interface SampleEntityMapper {
	List<SampleDomain> list();
}
