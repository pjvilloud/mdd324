package com.ipiecoles.java.mdd324.homepage.quote;

import com.ipiecoles.java.mdd324.homepage.quote.model.Quote;
import com.ipiecoles.java.mdd324.homepage.quote.model.Quotes;
import com.ipiecoles.java.mdd324.homepage.utils.Utils;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class QuoteService {
    public Quote getQuote() throws IOException {
        Genson genson = new GensonBuilder().useRuntimeType(true).create();
            final String pageContents = Utils.getPageContents("http://quotes.rest/qod.json");
            Quotes quotes = genson.deserialize(pageContents, Quotes.class);
            return quotes.getContents().getQuotes().get(0);
    }
}
