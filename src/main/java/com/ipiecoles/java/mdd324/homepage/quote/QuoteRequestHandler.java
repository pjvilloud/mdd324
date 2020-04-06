package com.ipiecoles.java.mdd324.homepage.quote;

import com.ipiecoles.java.mdd324.homepage.quote.model.Quote;
import com.ipiecoles.java.mdd324.homepage.quote.model.Quotes;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class QuoteRequestHandler extends SpringBootRequestHandler<Quotes, Quote> {
}
