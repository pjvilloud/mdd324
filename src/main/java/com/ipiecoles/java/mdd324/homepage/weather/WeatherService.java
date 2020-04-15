package com.ipiecoles.java.mdd324.homepage.weather;

import com.ipiecoles.java.mdd324.homepage.utils.Utils;
import com.ipiecoles.java.mdd324.homepage.weather.model.City;
import com.ipiecoles.java.mdd324.homepage.weather.model.WeatherApiResponse;
import com.ipiecoles.java.mdd324.homepage.weather.model.WeatherValues;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class WeatherService {

    public WeatherValues getWeather(final City input) throws Exception {
        Genson genson = new GensonBuilder().useRuntimeType(true).create();
        String city;
        try {
            final String pageContents = Utils.getPageContents("https://api.openweathermap.org/data/2.5/weather?q="+input.getCity()+"&appid=5dfc2a06c8157403e9107053a73aca92&lang=fr&main.temp=Celsius");
            WeatherApiResponse weatherResponse = genson.deserialize(pageContents, WeatherApiResponse.class);

            WeatherValues weatherReturn = new WeatherValues();
            weatherReturn.setIcon(weatherResponse.getWeather().get(0).getId());
            Date lever = new Date(weatherResponse.getSys().getSunrise()*1000L);
            Date coucher = new Date(weatherResponse.getSys().getSunset()*1000L);
            SimpleDateFormat df = new SimpleDateFormat("HH:mm");
            weatherReturn.setLever(df.format(lever));
            weatherReturn.setCoucher(df.format(coucher));
            weatherReturn.setHumidite(weatherResponse.getMain().getHumidity());
            weatherReturn.setTemp(kelvinToCelsius(weatherResponse.getMain().getTemp()));
            weatherReturn.setTemps(weatherResponse.getWeather().get(0).getDescription());

            return weatherReturn;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private Double kelvinToCelsius(Double fah){
        return Math.round((fah - 273.15)*100)*0.01d;
    }

}
