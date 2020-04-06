package com.ipiecoles.java.mdd324.homepage.weather;

import com.ipiecoles.java.mdd324.homepage.bitcoin.model.BitcoinApiInput;
import com.ipiecoles.java.mdd324.homepage.bitcoin.model.BitcoinApiResponse;
import com.ipiecoles.java.mdd324.homepage.weather.model.City;
import com.ipiecoles.java.mdd324.homepage.weather.model.WeatherApiInput;
import com.ipiecoles.java.mdd324.homepage.weather.model.WeatherApiResponse;
import com.ipiecoles.java.mdd324.homepage.weather.model.WeatherValues;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class WeatherRequestHandler extends SpringBootRequestHandler<City, WeatherValues> {
}
