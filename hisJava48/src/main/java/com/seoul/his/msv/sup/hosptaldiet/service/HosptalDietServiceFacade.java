package com.seoul.his.msv.sup.hosptaldiet.service;

import java.util.List;
import java.util.Map;

import com.seoul.his.msv.sup.hosptaldiet.to.HosptalDietCodeBean;
import com.seoul.his.msv.sup.hosptaldiet.to.IngredBean;


public interface HosptalDietServiceFacade {

	//화면로드 시 식재료 코드 가져오기
		List<HosptalDietCodeBean> findCodeList(Map<String, String> argsMap);

	    //조회조건에 맞는 식재료 목록 가져오기
		List<IngredBean> findIngredList(Map<String, String> argsMap);

		//식재료목록 배치
		void batchIngredProcess(List<IngredBean> ingredList);

		//화면로드 시 음식 코드 가져오기
		List<HosptalDietCodeBean> findFoodCodeList(Map<String, String> argsMap);







}
