package com.test;

import com.finance.User;
import org.junit.Test;

public class UserTest {

	@Test
	public void testSetUser() {
		User user = new User();

		String[] stockTickerArray = new String[] {"AAPL", "GOOG"};

		user.setStockTickers("AAPL+GOOG");
		user.setFullName("Test Test");
		user.setEmailAddress("test@test.com");
		user.setStockTickerArray(stockTickerArray);

		assert(user.getEmailAddress().equals("test@test.com"));
		assert(user.getStockTickerArray().equals(stockTickerArray));
		assert(user.getFullName().equals("Test Test"));
		assert(user.getStockTickers().equals("AAPL+GOOG"));
	}
}
