package com.motm.test;

import java.util.ArrayList;

import com.motm.helpers.Logger;
import com.motm.models.Item;
import com.motm.models.FileItemManager;


import android.test.AndroidTestCase;

/*
 * 		I wrote this to be an example for everyone
 * 		Just copy paste and rename what you need.
 * 
 */

public class ItemManagerTest extends AndroidTestCase
{
	
	private FileItemManager im;

	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		
		// ran before each test
		im = new FileItemManager();
	}

	@Override
	protected void tearDown() throws Exception
	{
		super.tearDown();
		
		// ran after each test
		im = null;
	}
	public void testGetMatches() throws Exception{
		
		Integer myItem = im.createItem(0, "testItem", "Atlanta", "", Item.Type.LOST, "keepsake", "");
		
		Integer [] matches = {
				im.createItem(0, "test", "Atlanta", "", Item.Type.FOUND, "keepsake", ""),
				im.createItem(0, "testItem", "Atlanta", "", Item.Type.FOUND, "heirloom", ""),
				im.createItem(0, "Item", "Atlanta", "", Item.Type.FOUND, "misc", ""),
				im.createItem(0, "TESTITEM", "Atlanta", "", Item.Type.FOUND, "misc", "")
		};
		
		Integer [] nonMatches = {
				
				im.createItem(0, "itemTest", "Athens", "", Item.Type.FOUND, "keepsake", ""),
				im.createItem(0, "testItem", "Athens", "", Item.Type.FOUND, "keepsake", ""),
				im.createItem(0, "itemTest", "Atlanta", "", Item.Type.FOUND, "keepsake", ""),
				im.createItem(0, "test", "Atlanta", "", Item.Type.LOST, "keepsake", ""),
				im.createItem(0, "test", "Atlanta", "", Item.Type.LOST, "keepsake", ""),
				im.createItem(0, "Item", "Atlanta", "", Item.Type.LOST, "keepsake", ""),
		};
		
		
		ArrayList<Item> imMatches = (ArrayList<Item>)im.getMatches(im.getItem(myItem));
		
		for( Integer match: matches ){
			Item item = im.getItem(match);
			assertTrue( imMatches.contains(item) );
		}
		for( Integer nonMatch: nonMatches ){
			Item item = im.getItem(nonMatch);
			assertTrue( !imMatches.contains(item) );
		}

		for( Integer match: matches )
			im.deleteItem(match);
		
		for( Integer nonMatch: nonMatches )
			im.deleteItem(nonMatch);
		
		imMatches = (ArrayList<Item>)im.getMatches(im.getItem(myItem));
		assertTrue( imMatches == null );
		
		im.deleteItem(myItem);
		
		imMatches = (ArrayList<Item>)im.getMatches(im.getItem(myItem));
		assertTrue( imMatches == null );
		
		/*
		imMatches = im.getMatches(im.getItem(null));
		assertTrue( imMatches == null );
		*/
		
		
	}
}
