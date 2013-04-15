package com.motm.test;

import com.motm.models.Account;
import com.motm.models.FileAccountManager;
import com.motm.models.interfaces.AccountManager;

import android.test.AndroidTestCase;


/*
 * 		I wrote this to be an example for everyone
 * 		Just copy paste and rename what you need.
 * 
 */

public class AccountTest extends AndroidTestCase
{
	private AccountManager accountManager;// I don't use this but it's here as an example

	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		
		// ran before each test
		accountManager = new FileAccountManager();
	}

	@Override
	protected void tearDown() throws Exception
	{
		super.tearDown();
		
		// ran after each test
		accountManager = null;
	}

	//
	// Each test must start with the word test...
	//
	
	public void testAccountGetName()
	{
		Account account = new Account(1, "", "", "", "", Account.State.UNLOCKED, 0);
		
		// make sure it's what I set it to
		String name = account.getName();
		assertEquals("", name);
	}

	public void testAccountSetName()
	{
		Account account = new Account(1, "", "", "", "", Account.State.UNLOCKED, 0);
		
		// make sure it's what I set it to
		boolean result = account.setName("new name");
		// I expect it to be true
		assertTrue(result);
		
		// check that the name was actually set
		// assume that getName is ok, because we test it seperately
		String name = account.getName();
		assertEquals("new name", name);
	}
	
	public void testFailedTest()
	{
		// this test will fail
		assertTrue(false);
	}
}
