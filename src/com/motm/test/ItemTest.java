package com.motm.test;


import java.util.GregorianCalendar;

import android.test.AndroidTestCase;

import com.motm.models.Item;


public class ItemTest extends AndroidTestCase {
	

	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		
		
	}

	@Override
	protected void tearDown() throws Exception
	{
		super.tearDown();
		
		
	}

	//
	// Each test must start with the word test...
	//
	
	public void testGetItemID()
	{
		Item item = new Item(1, 1, "", "", Item.Status.Open, "", Item.Type.Lost, "", "", new GregorianCalendar());
		
		// make sure it's what I set it to
		int itemID = item.getItemID();
		assertEquals(1, itemID);
	}

	
}


