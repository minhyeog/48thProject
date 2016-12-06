package com.seoul.his.msv.sup.hosptaldiet.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seoul.his.msv.sup.hosptaldiet.applicationService.HosptalDietApplicationService;
import com.seoul.his.msv.sup.hosptaldiet.to.HosptalDietCodeBean;
import com.seoul.his.msv.sup.hosptaldiet.to.IngredBean;


/**
 * @Package  com.seoul.his.acc.budget.service
 * @Class    BudgetServiceFacadeImpl.java
 * @Create   2016. 6. 27.
 * @Author   jeong
 * @Description
 *
 * @LastUpdated
 */

@Service
public class HosptalDietServiceFacadeImpl implements HosptalDietServiceFacade{
	@Autowired
	HosptalDietApplicationService hosptaldietApplicationService;



     //화면로드 시 식재료 코드
	@Override
	public List<HosptalDietCodeBean> findCodeList(Map<String, String> argsMap) {
		List<HosptalDietCodeBean> ingredCodeList = hosptaldietApplicationService.findCodeList(argsMap);
		return ingredCodeList;
	}

	//조회에 따른 식재료 리스트
	@Override
	public List<IngredBean> findIngredList(Map<String, String> argsMap) {
		List<IngredBean> ingredBeanList = hosptaldietApplicationService.findIngredList(argsMap);
		return ingredBeanList;
	}
	// 식재료배치
	@Override
	public void batchIngredProcess(List<IngredBean> ingredList){
		hosptaldietApplicationService.batchIngredProcess(ingredList);
	}

	@Override
	public List<HosptalDietCodeBean> findFoodCodeList(Map<String, String> argsMap) {
		List<HosptalDietCodeBean> foodCodeList = hosptaldietApplicationService.findFoodCodeList(argsMap);
		return foodCodeList;
	}


}
