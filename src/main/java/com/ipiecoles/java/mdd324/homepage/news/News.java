package com.ipiecoles.java.mdd324.homepage.news;

import com.ipiecoles.java.mdd324.homepage.news.model.Item;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.function.Function;

public class News implements Function<Object, List<Item>> {
    @Autowired
    private NewsService newsService;

    @Override
    public List<Item> apply(Object o) {
        try {
            return newsService.getLastNews();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
