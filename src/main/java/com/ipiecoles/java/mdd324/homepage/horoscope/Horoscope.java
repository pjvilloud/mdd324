package com.ipiecoles.java.mdd324.homepage.horoscope;

import com.ipiecoles.java.mdd324.homepage.horoscope.model.HoroscopeApiInput;
import com.ipiecoles.java.mdd324.homepage.horoscope.model.HoroscopeResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;

public class Horoscope implements Function<HoroscopeApiInput, HoroscopeResponse> {
    @Autowired
    private HoroscopeService horoscopeService;

    @Override
    public HoroscopeResponse apply(HoroscopeApiInput horoscopeApiInput) {
        try {
            return horoscopeService.getHoroscope(horoscopeApiInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
