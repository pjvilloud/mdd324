package com.ipiecoles.java.mdd324.homepage.bitcoin;

import com.ipiecoles.java.mdd324.homepage.bitcoin.model.BitcoinApiInput;
import com.ipiecoles.java.mdd324.homepage.bitcoin.model.BitcoinApiResponse;
import com.ipiecoles.java.mdd324.homepage.utils.Utils;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BitcoinService {

    public BitcoinApiResponse getBitcoinRates(BitcoinApiInput input) throws Exception {
        Genson genson = new GensonBuilder().useRuntimeType(true).create();
        try {
            final String pageContents = Utils.getPageContents("https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms="+input.getCurrencyList());
            System.out.println(pageContents);
            Map<String, Object> currencies = genson.deserialize(pageContents, Map.class);
            BitcoinApiResponse bitcoinApiResponse= new BitcoinApiResponse(input.getBitcoinAmount(), new HashMap<>());
            for (String k : currencies.keySet()){
                Double montantCurrency = Double.parseDouble(currencies.get(k).toString());
                bitcoinApiResponse.getCurrenciesEquivalent().put(k, Math.round(montantCurrency * input.getBitcoinAmount()*100)*0.01);
            }

            return bitcoinApiResponse;
        } catch (Exception e) {
            throw new Exception("Erreur lors de la récupération des informations sur le cours du Bitcoin");
        }
    }

}
