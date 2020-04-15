package com.ipiecoles.java.mdd324.homepage.ephemeris;

import com.ipiecoles.java.mdd324.homepage.ephemeris.model.EphemerideApiResponse;
import com.ipiecoles.java.mdd324.homepage.ephemeris.model.EphemerisResponse;
import com.ipiecoles.java.mdd324.homepage.utils.Utils;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class EphemerisService {
    public EphemerisResponse getEphemeris() throws IOException {
        Genson genson = new GensonBuilder().useRuntimeType(true).create();
        final String pageContents = Utils.getPageContents("https://raw.githubusercontent.com/theofidry/ephemeris/master/src/ephemeris.json");
        EphemerideApiResponse ephemerideApiResponse = genson.deserialize(pageContents, EphemerideApiResponse.class);
        LocalDate now = LocalDate.now();
        String month = now.getMonth().name().toLowerCase();
        List<List<String>> listeTotale = new ArrayList<>();
        listeTotale.addAll(ephemerideApiResponse.getJanuary());
        listeTotale.addAll(ephemerideApiResponse.getFebruary());
        if (now.isLeapYear()) {
            listeTotale.remove(listeTotale.size()-1);
        }
        listeTotale.addAll(ephemerideApiResponse.getMarch());
        listeTotale.addAll(ephemerideApiResponse.getApril());
        listeTotale.addAll(ephemerideApiResponse.getMay());
        listeTotale.addAll(ephemerideApiResponse.getJune());
        listeTotale.addAll(ephemerideApiResponse.getJuly());
        listeTotale.addAll(ephemerideApiResponse.getAugust());
        listeTotale.addAll(ephemerideApiResponse.getSeptember());
        listeTotale.addAll(ephemerideApiResponse.getOctober());
        listeTotale.addAll(ephemerideApiResponse.getNovember());
        listeTotale.addAll(ephemerideApiResponse.getDecember());

        EphemerisResponse ephemerisResponse = new EphemerisResponse();
        ephemerisResponse.setJourAnnee(now.getDayOfYear());
        List<String> ephCurMonth = listeTotale.get(now.getDayOfYear());
        ephemerisResponse.setFeteDuJour(ephCurMonth.get(1) + " " + ephCurMonth.get(0));

        SimpleDateFormat df = new SimpleDateFormat("EEEE d MMMM y", Locale.FRANCE);
        ephemerisResponse.setDateJour(df.format(new Date()));
        ephemerisResponse.setNumSemaine((now.getDayOfYear() / 7) + 1);
        ephemerisResponse.setJoursRestants(now.isLeapYear() ? 366 - now.getDayOfYear() : 365 - now.getDayOfYear());
        return ephemerisResponse;
    }

}
