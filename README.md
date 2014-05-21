Yahoo Finance API
=================

This project is used to access Yahoo's Finance API. The goal of the project is to have the program run at the market's closing and send out a simple, straight forward digest via email for average investors who often forget to check their stocks.

Usage
=================

To execute the program, run:

java -jar yahoo-finance-api.jar

The parameters passed in to the program have the format of:

StockTickerSymbol+StockTickerSymbol

So a full example would be:

java -jar yahoo-finance-api.jar APPL+GOOG