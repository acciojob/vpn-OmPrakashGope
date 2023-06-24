package com.driver.model;

import javax.persistence.*;

@Entity
@Table
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn
    private User user;
    @ManyToOne
    @JoinColumn
    private ServiceProvider serviceProvider;

    public Connection() {
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
