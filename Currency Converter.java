package currencyConverter;

import java.util.ArrayList;
import java.util.HashMap;

public class Currency {

    public enum CurrencyCode {
        USD, CAD, EUR, GBP, CHF, CNY, JPY
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
    switch (currencyCode) {
        case USD:
            setExchangeRate(CurrencyCode.USD, 1.00);
            setExchangeRate(CurrencyCode.CAD, 1.35);
            setExchangeRate(CurrencyCode.EUR, 0.91);
            setExchangeRate(CurrencyCode.GBP, 0.79);
            setExchangeRate(CurrencyCode.CHF, 0.85);
            setExchangeRate(CurrencyCode.CNY, 7.13);
            setExchangeRate(CurrencyCode.JPY, 144.79);
            break;
        case CAD:
            setExchangeRate(CurrencyCode.USD, 0.75);
            setExchangeRate(CurrencyCode.CAD, 1.00);
            setExchangeRate(CurrencyCode.EUR, 0.68);
            setExchangeRate(CurrencyCode.GBP, 0.59);
            setExchangeRate(CurrencyCode.CHF, 0.64);
            setExchangeRate(CurrencyCode.CNY, 5.31);
            setExchangeRate(CurrencyCode.JPY, 144.79);
            break
        case EUR:
            setExchangeRate(CurrencyCode.USD, 1.09);
            setExchangeRate(CurrencyCode.CAD, 1.46);
            setExchangeRate(CurrencyCode.EUR, 1.00);
            setExchangeRate(CurrencyCode.GBP, 0.86);
            setExchangeRate(CurrencyCode.CHF, 0.93);
            setExchangeRate(CurrencyCode.CNY, 7.77);
            setExchangeRate(CurrencyCode.JPY, 158.27);
            break;
        case GBP:
            setExchangeRate(CurrencyCode.USD, 1.27);
            setExchangeRate(CurrencyCode.CAD, 1.70);
            setExchangeRate(CurrencyCode.EUR, 1.16);
            setExchangeRate(CurrencyCode.GBP, 1.00);
            setExchangeRate(CurrencyCode.CHF, 1.08);
            setExchangeRate(CurrencyCode.CNY, 9.03);
            setExchangeRate(CurrencyCode.JPY, 183.92);
            break;
        case CHF:
            setExchangeRate(CurrencyCode.USD, 1.17);
            setExchangeRate(CurrencyCode.CAD, 1.57);
            setExchangeRate(CurrencyCode.EUR, 1.07);
            setExchangeRate(CurrencyCode.GBP, 0.92);
            setExchangeRate(CurrencyCode.CHF, 1.00);
            setExchangeRate(CurrencyCode.CNY, 8.34);
            setExchangeRate(CurrencyCode.JPY, 169.94);
            break;
        case CNY:
            setExchangeRate(CurrencyCode.USD, 0.14);
            setExchangeRate(CurrencyCode.CAD, 0.19);
            setExchangeRate(CurrencyCode.EUR, 0.13);
            setExchangeRate(CurrencyCode.GBP, 0.11);
            setExchangeRate(CurrencyCode.CHF, 0.12);
            setExchangeRate(CurrencyCode.CNY, 1.00);
            setExchangeRate(CurrencyCode.JPY, 20.37);
            break;
        case JPY:
            setExchangeRate(CurrencyCode.USD, 0.0069);
            setExchangeRate(CurrencyCode.CAD, 0.0092);
            setExchangeRate(CurrencyCode.EUR, 0.0063);
            setExchangeRate(CurrencyCode.GBP, 0.0054);
            setExchangeRate(CurrencyCode.CHF, 0.0059);
            setExchangeRate(CurrencyCode.CNY, 0.049);
            setExchangeRate(CurrencyCode.JPY, 1.00);
            break;
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
