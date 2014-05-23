package com.finance;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class User {

	private String fullName;
	private String emailAddress;
	private String stockTickers;

	private String[] stockTickerArray;

	private static List<User> users = new ArrayList<User>();

	public String getFullName() {
		return fullName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getStockTickers() {
		return stockTickers;
	}

	public String[] getStockTickerArray() {
		return stockTickerArray;
	}

	public static List<User> getUsers() {
		return users;
	}

	public static void setUsers() {
		FileInputStream userDatabase = null;

		try {
			userDatabase = new FileInputStream(_USER_DATABASE);

			BufferedReader br = new BufferedReader(
				new InputStreamReader(userDatabase));

			String inputLine;

			while ((inputLine = br.readLine()) != null) {
				User user = new User();

				String[] userInformation = inputLine.split(",");

				user.setFullName(userInformation[0]);
				user.setEmailAddress(userInformation[1]);
				user.setStockTickers(userInformation[2]);
				user.setStockTickerArray(userInformation[2].split("\\+"));

				users.add(user);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setFullName(String userFullName) {
		fullName = userFullName;
	}

	public void setEmailAddress(String userEmailAddress) {
		emailAddress = userEmailAddress;
	}

	public void setStockTickers(String userStockTickers) {
		stockTickers = userStockTickers;
	}

	public void setStockTickerArray(String[] userStockTickers) {
		stockTickerArray = userStockTickers;
	}

	private static String _USER_DATABASE = "./users.txt";
}