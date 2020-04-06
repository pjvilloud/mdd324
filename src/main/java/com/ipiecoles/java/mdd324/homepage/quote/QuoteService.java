package com.ipiecoles.java.mdd324.homepage.quote;

import com.ipiecoles.java.mdd324.homepage.quote.model.Quote;
import com.ipiecoles.java.mdd324.homepage.quote.model.Quotes;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringJoiner;

@Service
public class QuoteService {
    public Quote getQuote() throws IOException {
        Genson genson = new GensonBuilder().useRuntimeType(true).create();
            final String pageContents = this.getPageContents("http://quotes.rest/qod.json");
            Quotes quotes = genson.deserialize(pageContents, Quotes.class);
            return quotes.getContents().getQuotes().get(0);
    }

    private String getPageContents(String address) throws IOException{
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
