package com.ipiecoles.java.mdd324.homepage.ephemeris;

import com.ipiecoles.java.mdd324.homepage.ephemeris.model.EphemerisResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.function.Function;

public class Ephemeris implements Function<Object, EphemerisResponse> {
    @Autowired
    private EphemerisService ephemerisService;

    @Override
    public EphemerisResponse apply(Object o) {
        try {
            return ephemerisService.getEphemeris();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
