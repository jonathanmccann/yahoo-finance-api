package com.test;

import java.util.Iterator;
import java.util.Map;

import com.finance.Stock;
import org.junit.Test;

public class StockInformationTest {

	@Test
	public void testGetStockInformation() {
		Map<String, Stock> stocks = Stock.getStocks();

		assert(stocks.size() == 2);

		Iterator it = stocks.entrySet().iterator();

		while (it.hasNext()) {
			Map.Entry stockPair = (Map.Entry)it.next();

			Stock stock = (Stock)stockPair.getValue();

			System.out.println("Stock name: " + stock.getName());
			System.out.println("Last Trade: " + stock.getLastTrade());
			System.out.println("Open: " + stock.getOpen());
			System.out.println("Change: " + stock.getChange());
			System.out.println("Percent Change: " + stock.getPercentChange());
			System.out.println("Ex-Dividend Date: " + stock.getExDividendDate());
			System.out.println("Dividend Pay Date: " + stock.getDividendPayDate());
			System.out.println("Day's Range: " + stock.getDayRange());

			System.out.println();
		}
	}

	@Test
	public void testGettersAndSetters() {
		Stock stock = new Stock();

		stock.setChange("+0.56");
		stock.setDayRange("1.52 - 2.56");
		stock.setDividendPayDate("Feb 28 2014");
		stock.setExDividendDate("March 31 2014");
		stock.setLastTrade("500.87");
		stock.setName("Apple");
		stock.setOpen("500.25");
		stock.setPercentChange("+0.23%");
		stock.setTickerSymbol("AAPL");

		assert(stock.getChange().equals("+0.56"));
		assert(stock.getDayRange().equals("1.52 - 2.56"));
		assert(stock.getDividendPayDate().equals("Feb 28 2014"));
		assert(stock.getExDividendDate().equals("March 31 2014"));
		assert(stock.getLastTrade().equals("500.87"));
		assert(stock.getName().equals("Apple"));
		assert(stock.getOpen().equals("500.25"));
		assert(stock.getPercentChange().equals("+0.23%"));
		assert(stock.getTicketSymbol().equals("AAPL"));
	}
}