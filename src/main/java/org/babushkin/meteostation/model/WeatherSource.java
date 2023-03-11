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

    @Column(name = "type_id")
    private long typeId;

    @Column(name = "version")
    private double version;

    public WeatherSource() {
    }

    public WeatherSource(String name, String comment, String macAddress, long typeId, double version) {
        this.name = name;
        this.comment = comment;
        this.macAddress = macAddress;
        this.typeId = typeId;
        this.version = version;
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

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof WeatherSource))
            return false;
        return Objects.equals(this.id, ((WeatherSource) obj).id) &&
                Objects.equals(this.name, ((WeatherSource) obj).name) &&
                Objects.equals(this.comment, ((WeatherSource) obj).comment) &&
                Objects.equals(this.macAddress, ((WeatherSource) obj).macAddress) &&
                Objects.equals(this.typeId, ((WeatherSource) obj).typeId) &&
                Objects.equals(this.version, ((WeatherSource) obj).version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.comment);
    }

    @Override
    public String toString() {
        return "Weather{" + "id=" + this.id + ", name = '" + this.name +
                "\''" + ", comment = '" + this.comment + "\'" +
                "\''" + ", macAddress = '" + this.macAddress + "\'" +
                "\''" + ", typeId = '" + this.typeId + "\'" +
                "\''" + ", version = '" + this.version + "\'" +'}';
    }
}
