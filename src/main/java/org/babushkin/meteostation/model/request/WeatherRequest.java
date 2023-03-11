package org.babushkin.meteostation.model.request;

public class WeatherRequest {
    private double airTemperature;
    private double humidity;
    private String mac;

    public double getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(double airTemperature) {
        this.airTemperature = airTemperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public WeatherRequest(double airTemperature, double humidity, String mac) {
        this.airTemperature = airTemperature;
        this.humidity = humidity;
        this.mac = mac;
    }
}
