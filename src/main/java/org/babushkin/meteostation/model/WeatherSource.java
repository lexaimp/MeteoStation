package org.babushkin.meteostation.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "weather_source")
public class WeatherSource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "Comment")
    private String comment;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof WeatherSource weatherSource))
            return false;
        return Objects.equals(this.id, weatherSource.id) &&
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
                "\''" + ", comment = '" + this.comment + "\'" + '}';
    }
}
