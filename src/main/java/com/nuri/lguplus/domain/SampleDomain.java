package com.nuri.lguplus.domain;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.nuri.lguplus.domain.common.DefaultField;

import lombok.Data;

@Data
public class SampleDomain extends DefaultField {

	@Valid
	@Size(min=3, max=5, message="3자이상 5자미만으로 작성해야 합니다.")
	String userId;
	String userName;

}
