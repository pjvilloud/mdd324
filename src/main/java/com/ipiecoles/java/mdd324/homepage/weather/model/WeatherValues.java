package com.ipiecoles.java.mdd324.homepage.weather.model;

public class WeatherValues {
    private String temps;

    private Integer icon;

    private Double temp;
    private Integer humidite;
    private String lever;
    private String coucher;

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Integer getHumidite() {
        return humidite;
    }

    public void setHumidite(Integer humidite) {
        this.humidite = humidite;
    }

    public String getLever() {
        return lever;
    }

    public void setLever(String lever) {
        this.lever = lever;
    }

    public String getCoucher() {
        return coucher;
    }

    public void setCoucher(String coucher) {
        this.coucher = coucher;
    }
}
