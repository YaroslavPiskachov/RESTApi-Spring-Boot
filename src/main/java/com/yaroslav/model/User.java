package com.yaroslav.model;


import javax.persistence.*;
import javax.persistence.Entity;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private String phone;

    public User(){
    }

    public User( String name, String phone) {

        this.name = name;
        this.phone = phone;
    }

    public User(long id, String name, String phone) {
        this.id=id;
        this.name = name;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
