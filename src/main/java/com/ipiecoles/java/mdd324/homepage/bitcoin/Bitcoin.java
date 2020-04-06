package com.ipiecoles.java.mdd324.homepage.bitcoin;

import com.ipiecoles.java.mdd324.homepage.bitcoin.model.BitcoinApiInput;
import com.ipiecoles.java.mdd324.homepage.bitcoin.model.BitcoinApiResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

public class Bitcoin implements Function<BitcoinApiInput, BitcoinApiResponse> {

    @Autowired
    private BitcoinService bitcoinService;

    @Override
    public BitcoinApiResponse apply(BitcoinApiInput bitcoinApiInput) {
        try {
            return bitcoinService.getBitcoinRates(bitcoinApiInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
