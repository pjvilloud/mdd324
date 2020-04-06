package com.ipiecoles.java.mdd324.homepage.bitcoin;

import com.ipiecoles.java.mdd324.homepage.bitcoin.model.BitcoinApiInput;
import com.ipiecoles.java.mdd324.homepage.bitcoin.model.BitcoinApiResponse;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

@Service
public class BitcoinService {

    public BitcoinApiResponse getBitcoinRates(BitcoinApiInput input) throws Exception {
        /*Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Access-Control-Allow-Origin", "https://pjvilloud.github.io");*/
        Genson genson = new GensonBuilder().useRuntimeType(true).create();
        try {
            final String pageContents = this.getPageContents("https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms="+input.getCurrencyList());
            System.out.println(pageContents);
            Map<String, Object> currencies = genson.deserialize(pageContents, Map.class);
            BitcoinApiResponse bitcoinApiResponse= new BitcoinApiResponse(input.getBitcoinAmount(), new HashMap<>());
            for (String k : currencies.keySet()){
                Double montantCurrency = Double.parseDouble(currencies.get(k).toString());
                bitcoinApiResponse.getCurrenciesEquivalent().put(k, Math.round(montantCurrency * input.getBitcoinAmount()*100)*0.01);
            }

//            String output = genson.serialize(bitcoinApiResponse);
//            return new GatewayResponse(output, headers, 200);
            return bitcoinApiResponse;
        } catch (Exception e) {
            throw new Exception("Erreur lors de la récupération des informations sur le cours du Bitcoin");
        }
    }

    private String getPageContents(String address) throws IOException {
        BufferedReader br = null;
        StringJoiner lines = new StringJoiner(System.lineSeparator());

        try {
            URL url = new URL(address);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return lines.toString();

    }
}
