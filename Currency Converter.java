package currencyConverter;

import java.util.ArrayList;
import java.util.HashMap;

public class Currency {

    public enum CurrencyCode {
        USD, EUR, GBP, CHF, CNY, JPY
    }

    private String name;
    private CurrencyCode currencyCode;
    private HashMap<CurrencyCode, Double> exchangeRates = new HashMap<>();

    public Currency(String name, CurrencyCode currencyCode) {
        this.name = name;
        this.currencyCode = currencyCode;
    }

    public String getName() {
        return name;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public HashMap<CurrencyCode, Double> getExchangeRates() {
        return exchangeRates;
    }

    public void setExchangeRate(CurrencyCode code, Double rate) {
        this.exchangeRates.put(code, rate);
    }

    public void setDefaultExchangeRates() {
        switch (name) {
            case "US Dollar":
                setExchangeRate(CurrencyCode.USD, 1.00);
                setExchangeRate(CurrencyCode.EUR, 0.93);
                setExchangeRate(CurrencyCode.GBP, 0.66);
                setExchangeRate(CurrencyCode.CHF, 1.01);
                setExchangeRate(CurrencyCode.CNY, 6.36);
                setExchangeRate(CurrencyCode.JPY, 123.54);
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
