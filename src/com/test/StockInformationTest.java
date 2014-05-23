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
}