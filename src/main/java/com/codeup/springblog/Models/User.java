package com.codeup.springblog.Models;

import com.codeup.springblog.Models.Post;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="users")
public class User {


//----------------------------------- ANNOTATIONS FOR DATABASE TABLE -----------------------------------\\

    @Id @GeneratedValue
    private int id;


    @Column(nullable= false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;


//------------------------------------------------------------------------------------------------------\\




//-------------------------------------------- CONSTRUCTORS ---------------------------------------------\\

    public User() {
    }

    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User (String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


//copy constructor; copy of the user class that will live in the session; copy the full constructor

    public User(User copy) {
        this.id = copy.id;
        this.username = copy.username;
        this.email = copy.email;
        this.password = copy.password;
    }
//------------------------------------------------------------------------------------------------------\\




//------------------------------------------ GETTERS/SETTERS -------------------------------------------\\


    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

//------------------------------------------------------------------------------------------------------\\




}
