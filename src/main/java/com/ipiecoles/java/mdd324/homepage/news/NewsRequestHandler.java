package com.ipiecoles.java.mdd324.homepage.news;

import com.ipiecoles.java.mdd324.homepage.news.model.Item;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import java.util.List;

public class NewsRequestHandler extends SpringBootRequestHandler<Object, List<Item>> {
}
