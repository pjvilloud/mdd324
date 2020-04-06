package com.ipiecoles.java.mdd324.homepage.ephemeris.model;

public class EphemerisResponse {

    private String dateJour;

    private int numSemaine;

    private String feteDuJour;

    private int jourAnnee;

    private int joursRestants;

    public String getDateJour() {
        return dateJour;
    }

    public void setDateJour(String dateJour) {
        this.dateJour = dateJour;
    }

    public int getNumSemaine() {
        return numSemaine;
    }

    public void setNumSemaine(int numSemaine) {
        this.numSemaine = numSemaine;
    }

    public String getFeteDuJour() {
        return feteDuJour;
    }

    public void setFeteDuJour(String feteDuJour) {
        this.feteDuJour = feteDuJour;
    }

    public int getJourAnnee() {
        return jourAnnee;
    }

    public void setJourAnnee(int jourAnnee) {
        this.jourAnnee = jourAnnee;
    }

    public int getJoursRestants() {
        return joursRestants;
    }

    public void setJoursRestants(int joursRestants) {
        this.joursRestants = joursRestants;
    }
}
