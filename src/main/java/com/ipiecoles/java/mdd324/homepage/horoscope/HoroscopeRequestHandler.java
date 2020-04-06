package com.ipiecoles.java.mdd324.homepage.horoscope;

import com.ipiecoles.java.mdd324.homepage.horoscope.model.HoroscopeApiInput;
import com.ipiecoles.java.mdd324.homepage.horoscope.model.HoroscopeResponse;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class HoroscopeRequestHandler extends SpringBootRequestHandler<HoroscopeApiInput, HoroscopeResponse> {
}
