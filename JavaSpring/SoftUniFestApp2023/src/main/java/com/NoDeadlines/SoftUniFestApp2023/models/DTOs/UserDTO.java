package com.NoDeadlines.SoftUniFestApp2023.dto;

import java.util.Objects;

public abstract class UserDTO {
    private int id;
    private String email;
    private String password;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return id == userDTO.id && Objects.equals(email, userDTO.email) && Objects.equals(password, userDTO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }
}
