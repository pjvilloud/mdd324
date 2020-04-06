package com.ipiecoles.java.mdd324.homepage.horoscope;

import com.amazonaws.services.lambda.runtime.Context;
import com.ipiecoles.java.mdd324.homepage.horoscope.model.HoroscopeResponse;
import com.ipiecoles.java.mdd324.homepage.horoscope.model.Item;
import com.ipiecoles.java.mdd324.homepage.horoscope.model.HoroscopeApiResponse;
import com.ipiecoles.java.mdd324.homepage.horoscope.model.HoroscopeApiInput;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
public class HoroscopeService {

    public HoroscopeResponse getHoroscope(final HoroscopeApiInput input) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(HoroscopeApiResponse.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        HoroscopeApiResponse horoscopeApiResponse = (HoroscopeApiResponse) jaxbUnmarshaller.unmarshal(new URL("https://www.asiaflash.com/horoscope/rss_horojour_" + input.getSigne().toLowerCase().replace("é","e") + ".xml"));

        Item i = horoscopeApiResponse.getChannel().getItems().get(0);
        String desc = i.getDescription();
        desc = desc.replace("\n", "");
        desc = desc.replace("\"", "\'");
        return new HoroscopeResponse(desc);
    }

}
