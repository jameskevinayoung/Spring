package com.codeup.springblog.Services;


import com.codeup.springblog.controllers.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostsServices {

    private List<Post> posts;

    public PostsServices() {
        posts = new ArrayList<>();
        createPosts();
    }


    public Post findOne(long id){
        return posts.get((int)id-1);
    }


    public List<Post> findAll(){
        return posts;
    }


    public Post save(Post post){
        post.setId(posts.size()+1);
        posts.add(post);
        return post;
    }


    private void createPosts(){
        this.save(new Post("My First Post", "I'm sick of this shit"));
        this.save(new Post("A good day", "to learn code"));
        this.save(new Post("A bad day", "to learn code on an empty stomach"));

    }


}

