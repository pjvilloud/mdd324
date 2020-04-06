package com.ipiecoles.java.mdd324.homepage.movies;

import com.ipiecoles.java.mdd324.homepage.movies.model.MoviesResponse;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class MoviesRequestHandler extends SpringBootRequestHandler<Object, MoviesResponse> {
}
