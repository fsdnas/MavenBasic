package com.mobileapp.service;

import com.mobileapp.exceptions.MobileIdNotFoundException;
import com.mobileapp.exceptions.MobileNotFoundException;

public class Client {

	public static void main(String[] args) {
		IMobileService mobileService = new MobileService();
		try {
			System.out.println(mobileService.findMobileById(2));
		} catch (MobileIdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			mobileService.findMobileByBrand("Samsung").forEach(System.out::println);
		} catch (MobileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
