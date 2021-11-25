package com.mobileapp.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.mobileapp.exceptions.MobileIdNotFoundException;
import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public class MobileService implements IMobileService {
	private List<Mobile> mobileList = Arrays.asList(new Mobile("M32", "Samsung", 15999, 1),
			new Mobile("11 mini", "Apple", 59000, 2), new Mobile("A32", "Samsung", 49552, 3),
			new Mobile("F52", "Samsung", 19999, 4), new Mobile("M50", "Samsung", 25000, 5));

	public List<Mobile> showMobiles() {
		Collections.sort(mobileList, (mobile1, mobile2) -> {
			return mobile1.getBrand().compareTo(mobile2.getBrand());
		});
		return mobileList;
	}

	public List<Mobile> findMobileByBrand(String brand) throws MobileNotFoundException {

		List<Mobile> findByBrand = showMobiles().stream().filter(mobile -> mobile.getBrand().equals(brand))
				.collect(Collectors.toList());
		if (mobileList.isEmpty()) {
			throw new MobileNotFoundException("brand not found");
		}
		return findByBrand;
	}

	public Mobile findMobileById(int mobileId) throws MobileIdNotFoundException {

		return showMobiles().stream().filter((mobile) -> mobile.getMobileId() == mobileId).findFirst()
				.orElseThrow(() -> new MobileIdNotFoundException("mobile id not available"));
	}

}
