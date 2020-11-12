package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;
@Component
@ImportResource("classpath:spring-config.xml")
public class MenuItemDaoCollectionImpl implements MenuItemDao  {
	@Autowired
	
	private List<MenuItem> menuItemList;
	
	/*public MenuItemDaoCollectionImpl()  {
		List<MenuItem> mList = new ArrayList<>();
		
		if(menuItemList==null) {
			mList.add(new MenuItem(1, "Sandwich", 99.0f, true, DateUtil.convertToDate("15/03/2017"),"Main Course", true));
			mList.add(new MenuItem(2, "Burger", 129.0f, true, DateUtil.convertToDate("23/12/2017"),"Main Course", false));
			mList.add(new MenuItem(3, "Pizza", 149.0f, true, DateUtil.convertToDate("21/08/2018"),"Main Course", false));
		}
		
		menuItemList = mList;
		
		}*/
	
		@Override
		public List<MenuItem> getMenuItemListAdmin() {
			return menuItemList;
		}

		public List<MenuItem> getMenuItemList() {
			return menuItemList;
		}

		public void setMenuItemList(List<MenuItem> menuItemList) {
			this.menuItemList = menuItemList;
		}

		@Override
		public List<MenuItem> getMenuItemListCustomer(){
			
			List<MenuItem> custList=new ArrayList<MenuItem>();
			Date today=DateUtil.convertToDate("01/01/2018");
			for(MenuItem m:menuItemList) {
				if(today.after(m.getDateOfLaunch()) &&m.isActive())
					custList.add(m);
				}
			return custList;
		}
		@Override
		public void modifyMenuItem(MenuItem menuItem) {
			
			
			for(MenuItem m:menuItemList) {
				if(m.equals(menuItem)) {
					m.setId(menuItem.getId());
					m.setName(menuItem.getName());
					m.setPrice(menuItem.getPrice());
					m.setActive(menuItem.isActive());
					m.setDateOfLaunch(menuItem.getDateOfLaunch());
					m.setCategory(menuItem.getCategory());
					m.setFreeDelivery(menuItem.isFreeDelivery());	
				}
				
			}	
		}
		
		@Override
		public MenuItem getMenuItem(long menuItemId) {
			MenuItem mItem=new MenuItem() ;
			for(MenuItem m:menuItemList) {
				if(m.getId()==menuItemId) {
					mItem=m;
				}
			}
			return mItem;
		}
}

