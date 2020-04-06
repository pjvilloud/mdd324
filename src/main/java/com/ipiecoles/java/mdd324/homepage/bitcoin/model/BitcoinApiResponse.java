package com.ipiecoles.java.mdd324.homepage.bitcoin.model;

import java.util.HashMap;

public class BitcoinApiResponse {

    private Double bitcoinAmount = 0d;

    private HashMap<String, Double> currenciesEquivalent = new HashMap<>();

    public BitcoinApiResponse(Double bitcoinAmount, HashMap<String, Double> currenciesEquivalent) {
        this.bitcoinAmount = bitcoinAmount;
        this.currenciesEquivalent = currenciesEquivalent;
    }

    public Double getBitcoinAmount() {
        return bitcoinAmount;
    }

    public void setBitcoinAmount(Double bitcoinAmount) {
        this.bitcoinAmount = bitcoinAmount;
    }

    public HashMap<String, Double> getCurrenciesEquivalent() {
        return currenciesEquivalent;
    }

    public void setCurrenciesEquivalent(HashMap<String, Double> currenciesEquivalent) {
        this.currenciesEquivalent = currenciesEquivalent;
    }
}
