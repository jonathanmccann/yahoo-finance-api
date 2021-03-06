package com.test;

import com.finance.Stock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({StockInformationTest.class, UserTest.class})
public class YahooFinanceAPITestSuite {

	@BeforeClass
	public static void setUpClass() throws Exception {
		String[] stockTickers = {"AAPL", "GOOG"};

		Stock.setStocks(stockTickers);
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
}