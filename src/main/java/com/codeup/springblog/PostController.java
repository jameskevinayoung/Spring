package com.codeup.springblog;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

//    GET	/posts	posts index page
//    GET	/posts/{id}	view an individual post
//    GET	/posts/create	view the form for creating a post
//    POST	/posts/create	create a new post

    List<Post> posts = new ArrayList<>();

public PostControler(){
    posts.add(new Post("My First Post", "I'm sick of this shit"));
}



    @GetMapping("/posts") //this will continue to add content each time to repeat
//    @ResponseBody
    public String postsIndex(Model viewModel){
        posts.add(new Post("A good day", "to learn code"));
        posts.add(new Post("A bad day", "to learn code on an empty stomach"));

        viewModel.addAttribute("posts", posts);//view model
        return "posts/index"; //pathway
    }


    @GetMapping("/posts/{id}")
//    @ResponseBody
    public String individualPost(@PathVariable int id, Model viewModel){
        viewModel.addAttribute("post", posts.get(id-1));//the id points to the index, but the index starts at 0 not 1

        return "posts/show";
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
