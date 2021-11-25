package com.mobileapp.service;

import java.util.List;

import com.mobileapp.exceptions.MobileIdNotFoundException;
import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public interface IMobileService {

	//mock this interface
	
	
	List<Mobile> showMobiles();

	List<Mobile> findMobileByBrand(String brand) throws MobileNotFoundException;

	Mobile findMobileById(int mobileId) throws MobileIdNotFoundException;
}
