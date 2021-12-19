package com.mobile.service;

import java.util.List;
import java.util.stream.Collectors;

import com.mobile.exceptions.IdNotFoundException;
import com.mobile.exceptions.MobileNotFoundException;
import com.mobile.model.Mobile;
import com.mobile.repository.IMobileRepository;
import com.mobile.repository.MobileRepositoryImpl;

public class MobileServiceImpl implements IMobileService {
	
	IMobileRepository mobileRepository = new MobileRepositoryImpl();
	
	@Override
	public void addMobile(Mobile mobile){
		mobileRepository.addMobile(mobile);

	}

	@Override
	public void updateMobile(int mobileId, float price) throws IdNotFoundException {
		mobileRepository.updateMobile(mobileId, price);

	}

	@Override
	public Mobile findById(int mobileId) throws IdNotFoundException{
		return mobileRepository.findById(mobileId);
	}

	@Override
	public void deleteMobile(int mobileId){
		// TODO Auto-generated method stub

	}

	@Override
	public List<Mobile> findAllMobiles() {
		
		return mobileRepository.findAllMobiles().stream().sorted((item1,item2)-> item1.getBrand().compareTo(item2.getBrand())).collect(Collectors.toList());
		
	}

	@Override
	public List<Mobile> findByBrand(String brand) throws MobileNotFoundException {
		
		return mobileRepository.findByBrand(brand).stream().sorted((item1,item2)-> item1.getBrand().compareTo(item2.getBrand())).collect(Collectors.toList());
	}

	@Override
	public List<Mobile> findByBrandAndModelStarting(String brand, String modelLike) throws MobileNotFoundException {
		return mobileRepository.findByBrandAndModelStarting(brand, modelLike).stream().sorted((item1,item2)-> item1.getBrand().compareTo(item2.getBrand())).collect(Collectors.toList());
		
	}

	@Override
	public List<Mobile> findByOS(String OS) throws MobileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mobile> findByLesserPrice(double lowPrice) throws MobileNotFoundException {
		
	return mobileRepository.findByLesserPrice(lowPrice).stream().sorted((price1,price2)-> price1.getBrand().compareTo(price2.getBrand())).collect(Collectors.toList());
	}

}
