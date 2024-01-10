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

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
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
                setExchangeRates("USD", 1.00);
                setExchangeRates("EUR", 0.93);
                setExchangeRates("GBP", 0.66);
                setExchangeRates("CHF", 1.01);
                setExchangeRates("CNY", 6.36);
                setExchangeRates("JPY", 123.54);
                break;
            // Repeat for other currencies
        }
    }

    public static ArrayList<Currency> initializeCurrencies() {
        ArrayList<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency("US Dollar", "USD"));
        currencies.add(new Currency("Euro", "EUR"));
        // Add other currencies

        for (Currency currency : currencies) {
            currency.setDefaultExchangeRates();
        }

        return currencies;
    }

    public static Double convertCurrency(Double amount, Double exchangeRate) {
        Double convertedAmount = amount * exchangeRate;
        return Math.round(convertedAmount * 100d) / 100d;
    }
}

