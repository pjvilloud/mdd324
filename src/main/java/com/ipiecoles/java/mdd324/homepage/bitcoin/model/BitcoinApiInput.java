package com.ipiecoles.java.mdd324.homepage.bitcoin.model;

public class BitcoinApiInput {

    private Double bitcoinAmount;
    private String currencyList;

    public BitcoinApiInput() {
    }

    public BitcoinApiInput(Double bitcoinAmount, String currencyList) {
        this.bitcoinAmount = bitcoinAmount;
        this.currencyList = currencyList;
    }

    public Double getBitcoinAmount() {
        return bitcoinAmount;
    }

    public void setBitcoinAmount(Double bitcoinAmount) {
        this.bitcoinAmount = bitcoinAmount;
    }

    public String getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(String currencyList) {
        this.currencyList = currencyList;
    }

    @Override
    public String toString() {
        return "BitcoinApiInput{" +
                "bitcoinAmount=" + bitcoinAmount +
                ", currencyList='" + currencyList + '\'' +
                '}';
    }
}
