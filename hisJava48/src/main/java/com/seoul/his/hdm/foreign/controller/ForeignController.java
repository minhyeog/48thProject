package com.seoul.his.hdm.foreign.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.xapi.data.PlatformData;
import com.seoul.his.hdm.foreign.service.ForeignServiceFacade;
import com.seoul.his.hdm.foreign.to.ForeignBean;
import com.seoul.his.common.util.DataSetBeanMapper;

/**
 * @Package  com.seoul.his.acc.budget.controller
 * @Class    BudgBimokController.java
 * @Create   2016. 6. 10.
 * @Author   jeong
 * @Description
 *
 * @LastUpdated 
 */

@Controller
public class ForeignController {
	
	@Autowired
	DataSetBeanMapper dataSetBeanMapper; 
	@Autowired
	ForeignServiceFacade foreignServiceFacade;
	
	@RequestMapping("hdm/foreign/findForeignList.do")
	public void findForeignList(HttpServletRequest request, HttpServletResponse response) throws Exception{
	    PlatformData inData = (PlatformData) request.getAttribute("inData");
		PlatformData outData = (PlatformData) request.getAttribute("outData");
		Map<String, String> argsMap = dataSetBeanMapper.variablesToMap(inData); 
		List<ForeignBean> foreignList = foreignServiceFacade.findForeignList(argsMap);
		dataSetBeanMapper.beansToDataset(outData, foreignList, ForeignBean.class);
	}
}
