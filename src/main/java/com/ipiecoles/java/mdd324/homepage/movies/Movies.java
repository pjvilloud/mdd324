package com.ipiecoles.java.mdd324.homepage.movies;

import com.ipiecoles.java.mdd324.homepage.movies.model.MoviesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import java.util.function.Function;

public class Movies implements Function<Object, MoviesResponse> {
    @Autowired
    private MoviesService moviesService;

    @Override
    public MoviesResponse apply(Object o) {
        try {
            return moviesService.getMovies();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
