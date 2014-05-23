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

Configuration Files
=================

**config.properties** (The e-mail address and password are used to connect to a mail client to send out the e-mail digests):

email.address=  
password=  
mail.smtp.auth=  
mail.smtp.starttls.enable=  
mail.smtp.host=  
mail.smtp.port=  

**users.txt**:

This file is used to hold the user's information who wish to receive digests. It is in the format:

userFullName,userEmailAddress,userStockTicker+userStockTicker