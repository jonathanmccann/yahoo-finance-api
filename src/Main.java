import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main (String[] args) {
		try {
			for (String arguments : args) {
				URL yahooFinanceURL = new URL("http://finance.yahoo.com/d/quotes.csv?s=" + arguments + "&f=l1oc6p2qr1mn");

				URLConnection urlConnection = yahooFinanceURL.openConnection();

				BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

				String inputLine;

				while ((inputLine = br.readLine()) != null) {
					String[] stockInformation = inputLine.split(",");

					System.out.println("Name - " + stockInformation[7].replace("\"", "").trim());
					System.out.println("Last Trade - $" + stockInformation[0]);
					System.out.println("Open - $" + stockInformation[1]);
					System.out.println("Change - " + stockInformation[2].replace("\"", ""));
					System.out.println("Percent Change - " + stockInformation[3].replace("\"", ""));
					System.out.println("Ex-Dividend Date - " + stockInformation[4].replace("\"", ""));
					System.out.println("Dividend Pay Date - " + stockInformation[5].replace("\"", ""));
					System.out.println("Day's Range - " + stockInformation[6].replace("\"", ""));

					System.out.println();
				}

				br.close();
			}
		}
		catch (Exception e) {
			System.out.println("Could not access URL");
		}
	}
}

/*
Special Tags (placed after "&f="

a Ask
a2 Average Daily Volume
a5 Ask Size
b Bid
b2 Ask (Real-time)
b3 Bid (Real-time)
b4 Book Value
b6 Bid Size
c Change & Percent Change
c1 Change
c3 Commission
c6 Change (Real-time)
c8 After Hours Change (Real-time)
d Dividend/Share
d1 Last Trade Date
d2 Trade Date
e Earnings/Share
e1 Error Indication (returned for symbol changed / invalid)
e7 EPS Estimate Current Year
e8 EPS Estimate Next Year
e9 EPS Estimate Next Quarter
f6 Float Shares
g Day's Low
h Day's High
j 52-week Low
k 52-week High
g1 Holdings Gain Percent
g3 Annualized Gain
g4 Holdings Gain
g5 Holdings Gain Percent (Real-time)
g6 Holdings Gain (Real-time)
i More Info
i5 Order Book (Real-time)
j1 Market Capitalization
j3 Market Cap (Real-time)
j4 EBITDA
j5 Change From 52-week Low
j6 Percent Change From 52-week Low
k1 Last Trade (Real-time) With Time
k2 Change Percent (Real-time)
k3 Last Trade Size
k4 Change From 52-week High
k5 Percebt Change From 52-week High
l Last Trade (With Time)
l1 Last Trade (Price Only)
l2 High Limit
l3 Low Limit
m Day's Range
m2 Day's Range (Real-time)
m3 50-day Moving Average
m4 200-day Moving Average
m5 Change From 200-day Moving Average
m6 Percent Change From 200-day Moving Average
m7 Change From 50-day Moving Average
m8 Percent Change From 50-day Moving Average
n Name
n4 Notes
o Open
p Previous Close
p1 Price Paid
p2 Change in Percent
p5 Price/Sales
p6 Price/Book
q Ex-Dividend Date
r P/E Ratio
r1 Dividend Pay Date
r2 P/E Ratio (Real-time)
r5 PEG Ratio
r6 Price/EPS Estimate Current Year
r7 Price/EPS Estimate Next Year
s Symbol
s1 Shares Owned
s7 Short Ratio
t1 Last Trade Time
t6 Trade Links
t7 Ticker Trend
t8 1 yr Target Price
v Volume
v1 Holdings Value
v7 Holdings Value (Real-time)
w 52-week Range
w1 Day's Value Change
w4 Day's Value Change (Real-time)
x Stock Exchange
 */