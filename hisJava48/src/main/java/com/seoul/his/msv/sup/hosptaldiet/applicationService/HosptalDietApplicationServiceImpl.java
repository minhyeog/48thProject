package com.seoul.his.msv.sup.hosptaldiet.applicationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.seoul.his.msv.sup.hosptaldiet.dao.FoodDAO;
import com.seoul.his.msv.sup.hosptaldiet.dao.IngredDAO;
import com.seoul.his.msv.sup.hosptaldiet.to.HosptalDietCodeBean;
import com.seoul.his.msv.sup.hosptaldiet.to.IngredBean;

/**
 * @Package  com.seoul.his.acc.budget.applicationService
 * @Class    AccBudgetApplicationServiceImpl.java
 * @Create   2016. 6. 27.
 * @Author   jeong
 * @Description
 *
 * @LastUpdated
 */

@Component
public class HosptalDietApplicationServiceImpl implements HosptalDietApplicationService{
	@Autowired
	IngredDAO ingredDAO;
	@Autowired
	FoodDAO foodDAO;
	@Override
	public List<HosptalDietCodeBean>findCodeList(Map<String, String> argsMap){
	    List<HosptalDietCodeBean> ingredCodeList = ingredDAO.selectCodeList(argsMap);
		return ingredCodeList;
	}

	@Override
	public List<IngredBean> findIngredList(Map<String, String> argsMap) {
		List<IngredBean> ingredList = ingredDAO.selectIngredList(argsMap);
		return ingredList;
	}

	@Override
	public void batchIngredProcess(List<IngredBean> ingredList) {
		List<IngredBean> insertedList = new ArrayList<IngredBean>();
		List<IngredBean> updatedList = new ArrayList<IngredBean>();
		List<IngredBean> deletedList = new ArrayList<IngredBean>();

		for(IngredBean ingredBean:ingredList){
			switch(ingredBean.getStatus())
			{
			case "inserted" :
				insertedList.add(ingredBean);
				break;

			case "updated" :
				updatedList.add(ingredBean);
				break;

			case "deleted" :
				deletedList.add(ingredBean);
				break;
			}
		}
		if(insertedList.size() >0){
		addIngredList(insertedList);
		}
		if(updatedList.size() >0){
		modifyIngredList(updatedList);
		}
		if(deletedList.size() >0){
		removeIngredList(deletedList);
		}

	}

	void addIngredList(List<IngredBean> insertedList){
		for(IngredBean ingredBean:insertedList){
			ingredDAO.insertIngred(ingredBean);
		}
	}

	void modifyIngredList(List<IngredBean> updatedList){
		for(IngredBean ingredBean:updatedList){
			ingredDAO.updateIngred(ingredBean);
		}
	}

	void removeIngredList(List<IngredBean> deletedList){
		for(IngredBean ingredBean:deletedList){
			ingredDAO.deleteIngred(ingredBean);
		}
	}


	@Override
	public List<HosptalDietCodeBean> findFoodCodeList(Map<String, String> argsMap){
		List<HosptalDietCodeBean> foodCodeList = foodDAO.selectFoodCodeList(argsMap);
		return foodCodeList;
	}
}
