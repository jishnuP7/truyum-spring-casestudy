package com.cognizant.truyum.service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.truyum.dao.CartEmptyException;


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
		
		
		
		
		
		//service.addCartItem(userId, menuItemId);
		
		
	}
	@Test
	public void testremoveCartItem() {
		//boolean flag=false;
		//service.removeCartItem(userId, menuItemId);
		
	}

}
