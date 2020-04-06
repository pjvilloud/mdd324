package com.ipiecoles.java.mdd324.homepage.weather.model;

import java.util.List;

public class WeatherApiResponse {
    private List<WeatherValue> weather;
    private Main main;
    private Sys sys;
    private String name;
    private Integer cod;

    public List<WeatherValue> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherValue> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }
}
