package com.mobile.repository;

import java.util.List;

import com.mobile.exceptions.IdNotFoundException;
import com.mobile.exceptions.MobileNotFoundException;
import com.mobile.model.Mobile;

public interface IMobileRepository {

	
	//Called by Admin
		void addMobile(Mobile mobile);
		void updateMobile(int mobileId,float price)throws IdNotFoundException;
		Mobile findById(int mobileId) throws IdNotFoundException;
		void deleteMobile(int mobileId) throws IdNotFoundException;
		
		//Called by users
		List<Mobile> findAllMobiles();
		List<Mobile> findByBrand(String brand) throws MobileNotFoundException;
		List<Mobile> findByBrandAndModelStarting(String brand,String model) throws MobileNotFoundException;
		List<Mobile> findByOS(String OS) throws MobileNotFoundException;
		List<Mobile> findByLesserPrice(double lowPrice) throws MobileNotFoundException;
		
}