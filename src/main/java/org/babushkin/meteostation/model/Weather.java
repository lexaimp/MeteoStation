package org.babushkin.meteostation.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "date")
    private Date date;

    @Column(name = "air_temperature")
    private double airTemperature;

    @Column(name = "humidity")
    private double humidity;

    @Column(name = "source_id")
    private long sourceId;

    public Weather() {
    }

    public Weather(Date date, double airTemperature, double humidity, long sourceId) {
        this.date = date;
        this.airTemperature = airTemperature;
        this.humidity = humidity;
        this.sourceId = sourceId;
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

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public long getSourceId() {
        return sourceId;
    }

    public void setSourceId(long sourceId) {
        this.sourceId = sourceId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Weather))
            return false;
        return Objects.equals(this.id, ((Weather) obj).id) &&
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
                "\''" + ", humidity = '" + this.humidity +
                "\''" + ", source = '" + this.sourceId + "\'" + '}';
    }
}
