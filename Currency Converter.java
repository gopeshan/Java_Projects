package currencyConverter;

import java.util.ArrayList;
import java.util.HashMap;

public class Currency {

    private String name;
    private String shortName;
    private HashMap<String, Double> exchangeRates = new HashMap<>();

    public Currency(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public HashMap<String, Double> getExchangeRates() {
        return exchangeRates;
    }

    public void setExchangeRate(String currencyCode, Double rate) {
        this.exchangeRates.put(currencyCode, rate);
    }

    public void setDefaultExchangeRates() {
        switch (name) {
            case "US Dollar":
                setExchangeRate("USD", 1.00);
                setExchangeRate("EUR", 0.93);
                setExchangeRate("GBP", 0.66);
                setExchangeRate("CHF", 1.01);
                setExchangeRate("CNY", 6.36);
                setExchangeRate("JPY", 123.54);
                break;
            // Repeat for other currencies
        }
    }

    public static ArrayList<Currency> initializeCurrencies() {
        return new ArrayList<>(CurrencyName.getAllCurrencyNames()
                .stream()
                .map(name -> new Currency(name, CurrencyCode.getCodeForName(name)))
                .peek(Currency::setDefaultExchangeRates)
                .collect(Collectors.toList()));
    }

    public static Double convertCurrency(Double amount, Double exchangeRate) {
        return Math.round(amount * exchangeRate * 100d) / 100d;
    }
}
