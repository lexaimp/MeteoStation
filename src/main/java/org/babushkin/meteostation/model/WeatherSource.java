package org.babushkin.meteostation.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "weather_source")
public class WeatherSource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "Comment")
    private String comment;

    @Column(name = "mac_address")
    private String macAddress;

    public WeatherSource() {
    }

    public WeatherSource(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof WeatherSource))
            return false;
        return Objects.equals(this.id, ((WeatherSource) obj).id) &&
                Objects.equals(this.name, ((WeatherSource) obj).name) &&
                Objects.equals(this.comment, ((WeatherSource) obj).comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.comment);
    }

    @Override
    public String toString() {
        return "Weather{" + "id=" + this.id + ", name = '" + this.name +
                "\''" + ", comment = '" + this.comment + "\'" +
                "\''" + ", macAddress = '" + this.macAddress + "\'" + '}';
    }
}
