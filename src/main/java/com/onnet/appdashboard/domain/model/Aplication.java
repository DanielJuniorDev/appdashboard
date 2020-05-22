package com.onnet.appdashboard.domain.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "aplication")
public class Aplication {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "picture", nullable = true)
    private String picture;

    public Aplication(){}

    public Aplication(long id, String name, String url, Boolean active, String picture) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.active = active;
        this.picture = picture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Optional<String> getPicture() {
        return Optional.ofNullable(picture);
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aplication that = (Aplication) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
