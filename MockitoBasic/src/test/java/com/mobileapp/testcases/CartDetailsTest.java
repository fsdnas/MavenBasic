package com.mobileapp.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import com.mobileapp.exceptions.EmptyCartException;
import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;
import com.mobileapp.service.CartDetails;
import com.mobileapp.service.ICartService;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class CartDetailsTest {

	@Mock
	ICartService cartService;

	@InjectMocks
	CartDetails cartDetails;
	Mobile mobile1, mobile2, mobile3, mobile4, mobile5;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {

		mobile1 = new Mobile("D32", "Samsung", 15999, 1);
		mobile2 = new Mobile("SE", "Apple", 59000, 2);
		mobile3 = new Mobile("A32", "Samsung", 49552, 3);
		mobile4 = new Mobile("B52", "Samsung", 19999, 4);
		mobile5 = new Mobile("C50", "Samsung", 25000, 5);

		List<Mobile> mobileData = Arrays.asList(mobile1, mobile2, mobile3, mobile4, mobile5);

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("checking with add cart")
	void testAddCart() throws MobileNotFoundException {
		// calling cart service using mock
		doNothing().when(cartService).addToCart(mobile1);
		String actual = cartDetails.addToCart(mobile1);
		String expected = "added successfully";
		assertEquals(expected, actual, "invalid");

	}

	@Test
	@DisplayName("checking add cart exception")
	void testAddCartException() throws MobileNotFoundException {
		// calling cart service using mock
		doThrow(new MobileNotFoundException("invalid mobile")).when(cartService).addToCart(mobile1); // this returns no
		assertThrows(MobileNotFoundException.class, () -> cartDetails.addToCart(mobile1));

	}

	@Test
	@DisplayName("checking cart items")
	void testShowCart() throws EmptyCartException {
		List<Mobile> expectedMobile = Arrays.asList(mobile3, mobile4, mobile5);
		doReturn(Arrays.asList(mobile5, mobile4, mobile3)).when(cartService).showCart();
		List<Mobile> actualMobiles = cartDetails.showCart();
		assertEquals(expectedMobile, actualMobiles, "not equal");

	}
	@Test
	@DisplayName("checking cart with null")
	void testNullShowCart() throws MobileNotFoundException, EmptyCartException {
	    doReturn(null).when(cartService).showCart();
	    assertNull(cartDetails.showCart());
		
	}
	
	@Test
	@DisplayName("checking by removing items in cart")
	void testRemoveCartItems() throws EmptyCartException, MobileNotFoundException {
		doReturn(true).when(cartService).removeFromCart(mobile1);
		assertEquals(true, cartDetails.removeFromCart(mobile1));
	}
	
	@Test
	@DisplayName("checking cart with null")
	void testRemoveCartEmpty() throws EmptyCartException, MobileNotFoundException {
		doThrow(new MobileNotFoundException()).when(cartService).removeFromCart(mobile3);
		assertThrows(MobileNotFoundException.class, () -> cartDetails.removeFromCart(mobile3));
	}
	
	

}
