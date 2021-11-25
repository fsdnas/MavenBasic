package com.mobileapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.mobileapp.exceptions.MobileIdNotFoundException;
import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public class OrderDetails {
	
	public IMobileService getMobileService() {
		return mobileService;
	}

	public void setMobileService(IMobileService mobileService) {
		this.mobileService = mobileService;
	}

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	IMobileService mobileService;
	Mobile mobile =null;
	List<Mobile> mobileList;
	Mobile orderMobile(int mobileId) {
		try {
			mobile = mobileService.findMobileById(mobileId);
		} catch (MobileIdNotFoundException e) {
			
			e.printStackTrace();
		}
		return mobile;
	}
	
	public List<Mobile> showMobiles(String brand) throws MobileNotFoundException{
		try {
			mobileList= mobileService.findMobileByBrand(brand);
		} catch (MobileNotFoundException e) {
			System.out.println(e.getMessage());
			throw e;
		}
		if(mobileList != null) {
			return mobileList.stream().sorted((m1,m2)->m1.getModel().compareTo(m2.getModel())).collect(Collectors.toList());
		}
//		return mobileList.stream().sorted(Comparator.comparing(Mobile::getModel)).collect(Collectors.toList());
		return mobileList;
	}
}
