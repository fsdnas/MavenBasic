package com.mobileapp.service;

import java.util.Collections;
import java.util.List;

import com.mobileapp.exceptions.EmptyCartException;
import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;

public class CartDetails {

	ICartService cartService;

	public ICartService getCartService() {
		return cartService;
	}

	public void setCartService(ICartService cartService) {
		this.cartService = cartService;
	}

	public List<Mobile> showCart() throws EmptyCartException {
		List<Mobile> mobileList = cartService.showCart();

		if (mobileList != null) {
			Collections.sort(mobileList, (mobile1, mobile2) -> {
				return mobile1.getModel().compareTo(mobile2.getModel());
			});
		}
		return mobileList;
	}

	public String addToCart(Mobile mobile) throws MobileNotFoundException {
		cartService.addToCart(mobile);
		return "added successfully";

	}

	public boolean removeFromCart(Mobile mobile) throws MobileNotFoundException {
		boolean isRemoved = false;
		try {
			isRemoved = cartService.removeFromCart(mobile);
		} catch (MobileNotFoundException e) {
			throw e;
		}

		return isRemoved;
	}

}
