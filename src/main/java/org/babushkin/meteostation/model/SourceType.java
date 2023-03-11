package org.babushkin.meteostation.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "source_type")
public class SourceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

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

    public SourceType(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof SourceType))
            return false;
        return Objects.equals(this.id, ((SourceType) obj).id) &&
                Objects.equals(this.name, ((SourceType) obj).name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public String toString() {
        return "Weather{" + "id=" + this.id + ", name = '" + this.name + '}';
    }
}
