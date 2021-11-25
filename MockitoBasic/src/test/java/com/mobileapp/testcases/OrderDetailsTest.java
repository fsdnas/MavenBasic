package com.mobileapp.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mobileapp.exceptions.MobileNotFoundException;
import com.mobileapp.model.Mobile;
import com.mobileapp.service.IMobileService;
import com.mobileapp.service.MobileService;
import com.mobileapp.service.OrderDetails;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class OrderDetailsTest {

	// Mock the object

	@Mock
	IMobileService mobileService; // this is a proxy of Imobileservice
	// create an object of orderDetails

	@InjectMocks
	OrderDetails orderDetails;
	Mobile mobile1, mobile2, mobile3, mobile4, mobile5;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		orderDetails = new OrderDetails();
		orderDetails.setMobileService(mobileService);

		mobile1 = new Mobile("M32", "Samsung", 15999, 1);
		mobile2 = new Mobile("11 mini", "Apple", 59000, 2);
		mobile3 = new Mobile("A32", "Samsung", 49552, 3);
		mobile4 = new Mobile("F52", "Samsung", 19999, 4);
		mobile5 = new Mobile("M50", "Samsung", 25000, 5);

		List<Mobile> mobileList = Arrays.asList(mobile1, mobile2, mobile3, mobile4, mobile5);

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testShowMobiles() throws MobileNotFoundException {
		String brand = "Samsung";
		List<Mobile> expectedMobile = Arrays.asList(mobile3, mobile4, mobile1, mobile5);
		Mockito.when(mobileService.findMobileByBrand(brand))
				.thenReturn(Arrays.asList(mobile1, mobile3, mobile4, mobile5));

		List<Mobile> actualMobileList = orderDetails.showMobiles(brand);
		assertEquals(expectedMobile, actualMobileList, "list is not equal");

	}

	@Test
	void testShowMobilesEmpty() throws MobileNotFoundException {
		String brand = "Moto";

		Mockito.when(mobileService.findMobileByBrand("Moto")).thenReturn(new ArrayList<>());

		List<Mobile> actualMobileList = orderDetails.showMobiles(brand);
		assertEquals(0, actualMobileList.size(), "List should be empty");

	}

	@Test
	void testShowMobilesNull() throws MobileNotFoundException {

		String brand = "LG";
		Mockito.when(mobileService.findMobileByBrand("LG")).thenReturn(null);

		List<Mobile> actualMobileList = orderDetails.showMobiles(brand);
		assertNull(actualMobileList);
	}

	@Test
	void testshowMobilesInvalid() throws MobileNotFoundException {
		Mockito.when(mobileService.findMobileByBrand("vivo")).thenThrow(MobileNotFoundException.class);
		assertThrows(MobileNotFoundException.class, () -> orderDetails.showMobiles("vivo"));

	}
	
	@Test
	void testShowMobilesSortByBrand() throws MobileNotFoundException {
		String brand = "Samsung";
		List<Mobile> expectedMobiles = Arrays.asList(mobile3, mobile4, mobile1, mobile5);
		
		Mockito.when(mobileService.findMobileByBrand("Samsung"))
					.thenReturn(Arrays.asList(mobile1, mobile3, mobile4, mobile5));
		List<Mobile> actualMobileList = orderDetails.showMobiles(brand);
		
		assertEquals(expectedMobiles, actualMobileList, "List not equal");
	
	}

}
