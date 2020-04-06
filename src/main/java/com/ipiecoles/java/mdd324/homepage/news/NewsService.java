package com.ipiecoles.java.mdd324.homepage.news;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import com.ipiecoles.java.mdd324.homepage.news.model.Item;
import com.ipiecoles.java.mdd324.homepage.news.model.Rss;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

@Service
public class NewsService {

    public List<Item> getLastNews() throws Exception {
            JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Rss rss = (Rss) jaxbUnmarshaller.unmarshal( new URL("https://www.lemonde.fr/rss/une.xml") );
            return rss.getChannel().getItems().stream().limit(10).collect(Collectors.toList());
    }
}
