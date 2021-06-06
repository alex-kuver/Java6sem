package com.example.demo.persist;

import javax.persistence.*;
import java.util.List;

@Entity
    @Table(name="users")
    public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(
            mappedBy="user",
            cascade=CascadeType.ALL,
            orphanRemoval=true
    )
    private List<ShopProgram> shopPrograms;


    public User() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ShopProgram> getTrainPrograms() {
        return shopPrograms;
    }

    public void setSopPrograms(List<ShopProgram> shopPrograms) {
        this.shopPrograms = shopPrograms;
    }
}

