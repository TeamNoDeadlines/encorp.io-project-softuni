package com.NoDeadlines.SoftUniFestApp2023.models.DTOs;

import java.util.Objects;

public class ClientUserDTO extends com.NoDeadlines.SoftUniFestApp2023.dto.UserDTO {
    private String firstName;
    private String lastName;





    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClientUserDTO that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName);
    }
}