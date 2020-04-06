package com.ipiecoles.java.mdd324.homepage.quote;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.function.Function;

public class Quote implements Function<Object, com.ipiecoles.java.mdd324.homepage.quote.model.Quote> {

    @Autowired
    private QuoteService quoteService;
    @Override
    public com.ipiecoles.java.mdd324.homepage.quote.model.Quote apply(Object o) {
        try {
            return quoteService.getQuote();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
