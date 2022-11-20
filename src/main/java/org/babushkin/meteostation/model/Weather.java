package org.babushkin.meteostation.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "date")
    private Date date;

    @Column(name = "air_temperature")
    private double airTemperature;

    @Column(name = "humidity")
    private short humidity;

    @Column(name = "source")
    private int source;

    public Weather() {
    }

    public Weather(double airTemperature, short humidity, Date date) {
        this.airTemperature = airTemperature;
        this.humidity = humidity;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(double airTemperature) {
        this.airTemperature = airTemperature;
    }

    public short getHumidity() {
        return humidity;
    }

    public void setHumidity(short humidity) {
        this.humidity = humidity;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Weather weather))
            return false;
        return Objects.equals(this.id, weather.id) &&
                Objects.equals(this.date, ((Weather) obj).date) &&
                Objects.equals(this.airTemperature, ((Weather) obj).airTemperature) &&
                Objects.equals(this.humidity, ((Weather) obj).getHumidity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.date, this.airTemperature, this.humidity);
    }

    @Override
    public String toString() {
        return "Weather{" + "id=" + this.id + ", date = '" + this.date +
                "\''" + ", airTemperature = '" + this.airTemperature +
                "\''" + ", humidity = '" + this.humidity + "\'" + '}';
    }
}
