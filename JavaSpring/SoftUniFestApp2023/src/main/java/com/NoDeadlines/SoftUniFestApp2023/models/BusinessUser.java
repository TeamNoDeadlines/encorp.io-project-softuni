package com.NoDeadlines.SoftUniFestApp2023.models;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "business_user")
public class BusinessUser extends User {

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusinessUser that)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

