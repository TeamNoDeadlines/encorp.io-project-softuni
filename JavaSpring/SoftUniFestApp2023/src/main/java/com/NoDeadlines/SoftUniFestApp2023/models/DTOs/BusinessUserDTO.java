package com.NoDeadlines.SoftUniFestApp2023.models.DTOs;

import java.util.Objects;

public class BusinessUserDTO extends com.NoDeadlines.SoftUniFestApp2023.dto.UserDTO {
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
        if (!(o instanceof BusinessUserDTO that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
