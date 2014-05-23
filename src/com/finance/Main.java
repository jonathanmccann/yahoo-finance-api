package com.finance;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main (String[] args) {
		User.setUsers();

		List<User> users = User.getUsers();

		Set<String> stockTickers = new LinkedHashSet<String>();

		for (User user : users) {
			for (String stockTicker : user.getStockTickerArray()) {
				stockTickers.add(stockTicker);
			}
		}

		Stock.setStocks(
			stockTickers.toArray(new String[stockTickers.size()]));

		Mail.sendMail(users);
	}
}