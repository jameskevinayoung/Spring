package com.codeup.springblog.Services;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {


//----------------------------------- ANNOTATIONS FOR DATABASE TABLE -----------------------------------\\

    @Id @GeneratedValue
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String body;


    @ManyToOne
    private User user;
//------------------------------------------------------------------------------------------------------\\



//-------------------------------------------- CONSTRUCTORS ---------------------------------------------\\

    public Post(){}

    public Post(User user, String title, String body){
        this.user = user;
        this.title =title;
        this.body = body;
    }
    public Post(int id, User user, String title, String body){
        this.user = user;
        this.id = id;
        this.title=title;
        this.body = body;
    }

//------------------------------------------------------------------------------------------------------\\



//------------------------------------------ GETTERS/SETTERS -------------------------------------------\\

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
//------------------------------------------------------------------------------------------------------\\

}
