package com.driver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String originalIp;
    private String maskedIp;
    private boolean connected;
    private String getOriginalCountry;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Country country;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Connection> connectionList = new ArrayList<>();
    @ManyToMany(mappedBy = "users",cascade = CascadeType.ALL)
    private List<ServiceProvider> serviceProviderList = new ArrayList<>();

    public User() {
    }

    public int getId() {
        return id;
    }


    public String getGetOriginalCountry() {
        return getOriginalCountry;
    }

    public void setGetOriginalCountry(String getOriginalCountry) {
        this.getOriginalCountry = getOriginalCountry;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getOriginalIp() {
        return originalIp;
    }

    public String getMaskedIp() {
        return maskedIp;
    }

    public boolean getConnected() {
        return connected;
    }

    public Country getCountry() {
        return country;
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public List<ServiceProvider> getServiceProviderList() {
        return serviceProviderList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOriginalIp(String originalIp) {
        this.originalIp = originalIp;
    }

    public void setMaskedIp(String maskedIp) {
        this.maskedIp = maskedIp;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }

    public void setServiceProviderList(List<ServiceProvider> serviceProviderList) {
        this.serviceProviderList = serviceProviderList;
    }
}