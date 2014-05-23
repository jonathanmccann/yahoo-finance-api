package com.finance;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stock {
	private String change;
	private String lastTrade;
	private String open;
	private String percentChange;
	private String dayRange;
	private String dividendPayDate;
	private String exDividendDate;
	private String name;
	private String tickerSymbol;

	private static Map<String, Stock> stocks = new HashMap<String, Stock>();
	
	public String getName() {
		return name;
	}

	public String getLastTrade() {
		return lastTrade;
	}

	public String getOpen() {
		return open;
	}

	public String getChange() {
		return change;
	}

	public String getPercentChange() {
		return percentChange;
	}

	public String getExDividendDate() {
		return exDividendDate;
	}

	public String getDividendPayDate() {
		return dividendPayDate;
	}

	public String getDayRange() {
		return dayRange;
	}

	public String getTicketSymbol() {
		return tickerSymbol;
	}

	public static Map<String, Stock> getStocks() {
		return stocks;
	}

	public void setName(String stockName) {
		name = stockName;
	}

	public void setLastTrade(String stockLastTrade) {
		lastTrade = stockLastTrade;
	}

	public void setOpen(String stockOpen) {
		open = stockOpen;
	}

	public void setChange(String stockChange) {
		change = stockChange;
	}

	public void setPercentChange(String stockPercentChange) {
		percentChange = stockPercentChange;
	}

	public void setExDividendDate(String stockExDividendDate) {
		exDividendDate = stockExDividendDate;
	}

	public void setDividendPayDate(String stockDividendPayDate) {
		dividendPayDate = stockDividendPayDate;
	}

	public void setDayRange(String stockDayRange) {
		dayRange = stockDayRange;
	}

	public void setTickerSymbol(String stockTickerSymbol) {
		tickerSymbol = stockTickerSymbol;
	}

	public static void setStocks(String[] stockTickers) {
		try {
			StringBuilder sb = new StringBuilder(stockTickers.length * 2);

			for (int i = 0; i < stockTickers.length; i++) {
				sb.append(stockTickers[i]);

				if ((i + 1) < stockTickers.length) {
					sb.append("+");
				}
			}

			URL yahooFinanceURL = new URL(
				_YAHOO_URL_START + sb + _YAHOO_URL_END);

			URLConnection urlConnection = yahooFinanceURL.openConnection();

			BufferedReader br = new BufferedReader(
				new InputStreamReader(urlConnection.getInputStream()));

			String inputLine = "";
			int count = 0;

			while ((inputLine = br.readLine()) != null) {
				String[] stockInformation = inputLine.split(",");

				stocks.put(
					stockTickers[count],
					parseStockInformation(stockInformation));

				count++;
			}

			br.close();
		}
		catch (Exception e) {
			throw new RuntimeException("Could not access URL", e);
		}
	}

	public static List<Stock> getUsersStocks(User user) {
		List<Stock> usersStocks = new ArrayList<Stock>();

		String[] stockTickers = user.getStockTickerArray();

		for (String stockTicker : stockTickers) {
			usersStocks.add(stocks.get(stockTicker));
		}
				
		return usersStocks;
	}

	private static Stock parseStockInformation(String[] stockInformation) {

		Stock stock = new Stock();

		stock.setName(stockInformation[7].replace("\"", "").trim());
		stock.setLastTrade(stockInformation[0]);
		stock.setOpen(stockInformation[1]);
		stock.setChange(stockInformation[2].replace("\"", ""));
		stock.setPercentChange(stockInformation[3].replace("\"", ""));
		stock.setExDividendDate(stockInformation[4].replace("\"", ""));
		stock.setDividendPayDate(stockInformation[5].replace("\"", ""));
		stock.setDayRange(stockInformation[6].replace("\"", ""));

		return stock;
	}

	private static String _YAHOO_URL_START =
		"http://finance.yahoo.com/d/quotes.csv?s=";

	private static String _YAHOO_URL_END = "&f=l1oc6p2qr1mn";
}