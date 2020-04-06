package com.ipiecoles.java.mdd324.homepage.movies.model;

import java.util.List;

public class MoviesResponse {
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
