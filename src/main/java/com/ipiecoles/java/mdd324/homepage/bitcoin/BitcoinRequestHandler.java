package com.ipiecoles.java.mdd324.homepage.bitcoin;

import com.ipiecoles.java.mdd324.homepage.bitcoin.model.BitcoinApiInput;
import com.ipiecoles.java.mdd324.homepage.bitcoin.model.BitcoinApiResponse;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class BitcoinRequestHandler extends SpringBootRequestHandler<BitcoinApiInput, BitcoinApiResponse> {
}
