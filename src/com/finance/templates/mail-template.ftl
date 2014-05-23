Hi ${recipient},

Here is your digest:

<#list stocks as stock>
Stock: ${stock.getName()}

Last Trade: $${stock.getLastTrade()}
Open: $${stock.getOpen()}
Change: ${stock.getChange()}
Percent Change: ${stock.getPercentChange()}
Ex-Dividend Date:${stock.getExDividendDate()}
Dividend Pay Date: ${stock.getDividendPayDate()}
Day's Range: ${stock.getDayRange()}

</#list>
Regards,
Average Investor Digest