package com.mobile.client;

import com.mobile.model.Mobile;
import com.mobile.service.IMobileService;
import com.mobile.service.MobileServiceImpl;

public class Admin {

	public static void main(String[] args) {

		IMobileService mobileService = new MobileServiceImpl();
		Mobile mobile = new Mobile("12 Pro", "Apple", "128 GB", "Ios", 99999);
//		mobileService.addMobile(mobile);

//		mobile = new Mobile("M55", "Samsung", "128 GB", "Android",39999);
//		mobileService.addMobile(mobile);
//		System.out.println("Successs");

// update rows from mobile table

//		mobileService.updateMobile(1, 69000);

//		List<Mobile> result = mobileService.findAllMobiles();
//		System.out.println(result);

		// print all table data
//		mobileService.findAllMobiles().forEach(System.out::println);

// find by id 

//		try {
//			System.out.println(mobileService.findById(2));;
//			
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

// Get by brand
//		try {
//			System.out.println(mobileService.findByBrand("Apple"));
//		} catch (MobileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		try {
//			System.out.println(mobileService.findByBrandAndModelStarting("Apple", "4"));
//		} catch (MobileNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}

//		try {
//			System.out.println(mobileService.findByLesserPrice(10000));
//		} catch (MobileNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}

//		
	}

}
