package com.cognizant.truyum.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;


public class CartServiceTest {
	
	CartService service;
	@Rule
	public ExpectedException exceptionRule=ExpectedException.none();
	@Before
	public void initializeService() {
		ApplicationContext context=new AnnotationConfigApplicationContext();
		((AnnotationConfigApplicationContext) context).scan("com.cognizant.truyum");
		((AnnotationConfigApplicationContext) context).refresh();
		service=(CartService) context.getBean("cartService");
	}
	
	@Test
	public void testgetAllCartItemsException() throws CartEmptyException  {
		
		
		exceptionRule.expect(CartEmptyException.class);
		service.getAllCartItems(3);
	}
	@Test
	public void testaddCartItem() throws CartEmptyException {
		MenuItem item=new MenuItem(2, "Burger", 129.0f, true, DateUtil.convertToDate("23/12/2017"),"Main Course", false);
		List<MenuItem> lst=service.getAllCartItems(2);
		lst.add(item);
		boolean flag=false;
		if(lst.contains("burger")) {
			flag=true;
			service.addCartItem(2,2);
		}
		
		assertTrue(flag);
		
		
		
		
		//service.addCartItem(userId, menuItemId);
		
		
	}
	@Test
	public void testremoveCartItem() {
		//boolean flag=false;
		//service.removeCartItem(userId, menuItemId);
		
	}

}
