package com.motm.test;

import com.motm.helpers.FMSException;
import com.motm.models.Account;
import com.motm.models.FileAccountManager;
import com.motm.models.interfaces.AccountManager;

import android.test.AndroidTestCase;


/*
 * 		I wrote this to be an example for everyone
 * 		Just copy paste and rename what you need.
 * 
 */

public class AccountManagerTest extends AndroidTestCase
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
	
	// simple, not full
	public void testAccountCreate()
	{
		try {
			boolean result = accountManager.createAccount("loginName", "password", "name", "email");
			assertTrue(result);
		}
		catch(FMSException e){
			// no exception should be thrown
			assertFalse(true);
		}
	}
	
	public void testAttemptLogin()
	{
		// account create was tested before this, and if that passed then consider this test
		
		try {
			boolean result = accountManager.createAccount("loginName", "password", "name", "email");
			assertTrue(result);
		}
		catch(FMSException e){
			// no exception should be thrown
			assertFalse(true);
		}
		
		Account account = accountManager.attemptLogin("loginName", "password");
		assertTrue(account != null);
		
		// make sure account is tested before account manager
		assertEquals("loginName", account.getLoginName());
		assertEquals("password", account.getPassword());
	}
}
