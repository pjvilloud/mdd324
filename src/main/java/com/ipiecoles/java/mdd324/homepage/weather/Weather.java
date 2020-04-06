package com.ipiecoles.java.mdd324.homepage.weather;

import com.ipiecoles.java.mdd324.homepage.weather.model.City;
import com.ipiecoles.java.mdd324.homepage.weather.model.WeatherApiInput;
import com.ipiecoles.java.mdd324.homepage.weather.model.WeatherApiResponse;
import com.ipiecoles.java.mdd324.homepage.weather.model.WeatherValues;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

public class Weather implements Function<City, WeatherValues> {

    @Autowired
    private WeatherService weatherService;

    @Override
    public WeatherValues apply(City city) {
        try {
            return weatherService.getWeather(city);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
