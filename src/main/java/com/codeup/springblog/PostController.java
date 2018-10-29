package com.codeup.springblog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

//    GET	/posts	posts index page
//    GET	/posts/{id}	view an individual post
//    GET	/posts/create	view the form for creating a post
//    POST	/posts/create	create a new post

    @GetMapping("/posts")
    @ResponseBody
    public String postsIndex(){
        return "posts index page";
    }


    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable String id){
        return "view an individual post, id= "+ id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostForm(){
        return "view the form for creating a post";
    }



    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "create a new post";
    }

}