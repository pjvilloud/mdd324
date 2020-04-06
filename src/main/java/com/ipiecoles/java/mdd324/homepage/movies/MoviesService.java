package com.ipiecoles.java.mdd324.homepage.movies;

import java.net.URL;
import java.util.ArrayList;

import com.ipiecoles.java.mdd324.homepage.movies.model.Movie;
import com.ipiecoles.java.mdd324.homepage.movies.model.MoviesResponse;
import com.ipiecoles.java.mdd324.homepage.movies.model.Item;
import com.ipiecoles.java.mdd324.homepage.movies.model.Rss;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

@Service
public class MoviesService {

    public MoviesResponse getMovies() throws Exception {
        Genson genson = new GensonBuilder().useRuntimeType(true).create();
        JAXBContext jaxbContext = JAXBContext.newInstance(Rss.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Rss rss = (Rss) jaxbUnmarshaller.unmarshal(new URL("http://rss.allocine.fr/ac/cine/prochainement?format=xml"));
        MoviesResponse moviesResponse = new MoviesResponse();
        moviesResponse.setMovies(new ArrayList<>());
        int l = 10;
        for(Item i : rss.getChannel().getItems()){
            if(l-- <= 0){
                break;
            }
            Movie f = new Movie();
            f.setTitre(i.getTitle());
            f.setCategorie(i.getDescription().substring(3, i.getDescription().indexOf(" ")));
            f.setDescription(i.getDescription().substring(i.getDescription().indexOf("-") + 2, i.getDescription().indexOf("</p>")).replace("<p></p>", ""));
            moviesResponse.getMovies().add(f);
        }
        return moviesResponse;
    }
}
