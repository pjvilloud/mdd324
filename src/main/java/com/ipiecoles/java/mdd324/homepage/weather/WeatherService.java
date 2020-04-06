package com.ipiecoles.java.mdd324.homepage.weather;

import com.amazonaws.services.lambda.runtime.Context;
import com.ipiecoles.java.mdd324.homepage.weather.model.City;
import com.ipiecoles.java.mdd324.homepage.weather.model.WeatherApiResponse;
import com.ipiecoles.java.mdd324.homepage.weather.model.WeatherValues;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

@Service
public class WeatherService {

    public WeatherValues getWeather(final City input) throws Exception {
        Genson genson = new GensonBuilder().useRuntimeType(true).create();
        String city;
        try {
            final String pageContents = this.getPageContents("https://api.openweathermap.org/data/2.5/weather?q="+input.getCity()+"&appid=5dfc2a06c8157403e9107053a73aca92&lang=fr&main.temp=Celsius");
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

    private String getPageContents(String address) throws IOException {
        BufferedReader br = null;
        StringJoiner lines = new StringJoiner(System.lineSeparator());
        try {
            URL url = new URL(address);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return lines.toString();
    }

}
