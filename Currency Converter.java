package currencyConverter;

import java.util.ArrayList;
import java.util.HashMap;

public class Currency {

    public enum CurrencyName {
        US_DOLLAR, EURO, BRITISH_POUND, SWISS_FRANC, CHINESE_YUAN, JAPANESE_YEN
    }

    private CurrencyName name;
    private String shortName;
    private HashMap<String, Double> exchangeRates = new HashMap<>();

    public Currency(CurrencyName name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public CurrencyName getName() {
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
            case US_DOLLAR:
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
        ArrayList<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency(CurrencyName.US_DOLLAR, "USD"));
        currencies.add(new Currency(CurrencyName.EURO, "EUR"));
        // Add other currencies

        for (Currency currency : currencies) {
            currency.setDefaultExchangeRates();
        }

        return currencies;
    }

    public static Double convertCurrency(Double amount, Double exchangeRate) {
        return Math.round(amount * exchangeRate * 100d) / 100d;
    }
}
