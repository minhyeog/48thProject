package com.seoul.his.msv.sup.hosptaldiet.applicationService;

import java.util.List;
import java.util.Map;

import com.seoul.his.msv.sup.hosptaldiet.to.HosptalDietCodeBean;
import com.seoul.his.msv.sup.hosptaldiet.to.IngredBean;


public interface HosptalDietApplicationService {

	List<HosptalDietCodeBean> findCodeList(Map<String, String> argsMap);

	List<IngredBean> findIngredList(Map<String, String> argsMap);

	void batchIngredProcess(List<IngredBean> ingredList);

	List<HosptalDietCodeBean> findFoodCodeList(Map<String, String> argsMap);


}
