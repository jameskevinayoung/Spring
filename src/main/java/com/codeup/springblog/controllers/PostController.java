package com.codeup.springblog.controllers;
import com.codeup.springblog.Services.PostsServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

//This property is the connection (intermediary) that allows the controller class to access the services class
    private PostsServices postSvc;


/**
 * This is the constructor that takes the services property as a parameter for the CONTROLLER to access the SERVICES class
 * that will house the construction of data that the CONTROLLER will pull from to render information in a logical way
 * on the TEMPLATES.
 *
 * This is called Dependency Injection or passing things into the constructor of an object.
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


/**
 * the original structure of the postsIndex method will continue to add content to the page each time to repeat
 * unless you create a method that allows you to add a post to an existing list and return that list each time.
 * This will allow the functionality to update a list without it appending each time.
 *
 * ex: return posts; / vs / return posts + post;
 */



    @GetMapping("/posts")//this is where the user will go to initially or type into the browser
//    @ResponseBody //response body just renders from the controller this is not ideal when expanding the app architecture
    public String postsIndex(Model viewModel){ //use the model object to add attributes


//        posts.add(new Post("A good day", "to learn code"));
//        posts.add(new Post("A bad day", "to learn code on an empty stomach"));

        /**
         * 1) take the model parameter and use addAttribute method
         * 2) the first parameter in the addAttribute method identifies what the template will call the object (posts)
         * 3) the second parameter identifies what the object will be; since we are using a services property for functionality
         * 4) use findAll method, located in the services class, on the services property, which will return an array list of posts
         */
        viewModel.addAttribute("posts", postSvc.findAll());

        //now direct the user to the specified location to view the information
        return "posts/index"; //pathway on the server
        // the user only sees the information rendered on the /posts but html page is protected similar to WEB-INF folder
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
