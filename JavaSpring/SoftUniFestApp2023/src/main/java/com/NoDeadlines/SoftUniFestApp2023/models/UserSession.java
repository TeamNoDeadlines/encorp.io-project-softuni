package com.NoDeadlines.SoftUniFestApp2023.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.sql.Timestamp;

@Entity
@Table(name = "sessions")
public class UserSession {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "session_uuid")
    private String uuid;
    @JsonIgnore
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "expires_at")
    @JsonIgnore
    private Timestamp timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getUser() {
        return user_id;
    }

    public void setUser(int user) {
        this.user_id = user;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
