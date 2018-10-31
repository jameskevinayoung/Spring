package com.codeup.springblog.controllers;


import com.codeup.springblog.Services.PostsServices;
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


    //Services property
private PostsServices postSvc;


/**
 * This is constructor that takes the property as a parameter for the CONTROLLER to access the SERVICES class that will house the construction of data
 * that the CONTROLLER will pull from to render information in a logical way on the TEMPLATES
 *
 */


public PostController(PostsServices postSvc){
    this.postSvc = postSvc;
}

    /**
     * 1) creating a list object for the posts outside of methods provides access to the list by all methods
     * 2) creating a constructor allows the ability to construct the array list of posts
     * 3) to render on an html page remove the @ResponseBody annotation  and add the Model object
     * 4) use the .addAttribute() method to the Model object
     * 5) return a pathway to the page starting inside the appropriate folder without the leading forward slash
     *
     * NOTE: IT IS NOT THE JOB OF THE CONTROLLER TO HOLD/CONSTRUCT THE DATA BUT TO DO THE LOGIC
     */



//    List<Post> posts = new ArrayList<>();

//public PostController(){
//    posts.add(new Post("My First Post", "I'm sick of this shit"));
//}



    @GetMapping("/posts") //this will continue to add content each time to repeat
//    @ResponseBody
    public String postsIndex(Model viewModel){
//        posts.add(new Post("A good day", "to learn code"));
//        posts.add(new Post("A bad day", "to learn code on an empty stomach"));

        viewModel.addAttribute("posts", postSvc.findAll());//view model
        return "posts/index"; //pathway
    }


    @GetMapping("/posts/{id}")
//    @ResponseBody
    public String individualPost(@PathVariable int id, Model viewModel){
        viewModel.addAttribute("post", postSvc.findOne(id));//the id points to the index, but the index starts at 0 not 1

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
