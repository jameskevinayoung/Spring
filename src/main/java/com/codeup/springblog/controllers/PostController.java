package com.codeup.springblog.controllers;
import com.codeup.springblog.Services.Post;
import com.codeup.springblog.Services.PostsServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {


/**------------------------------------------------------------**\
|                      Services Property                         |
| This property is the connection (intermediary) that allows     |
| the controller class to access the services class              |
|                                                                |
/**____________________________________________________________**/

    private PostsServices postSvc;

/**------------------------------------------------------------------------------------------------------------------------**\
|                                              Dependency Injection                                                          |
|                                                                                                                            |
| This is the constructor that takes the services property as a parameter for the CONTROLLER to access the SERVICES class    |
| that will house the construction of data that the CONTROLLER will pull from to render information in a logical way         |
| on the TEMPLATES.                                                                                                          |
|                                                                                                                            |
| This is called  or passing things into the constructor of an object.                                                       |
/**________________________________________________________________________________________________________________________**/

    public PostController(PostsServices postSvc){
        this.postSvc = postSvc;
    }




/**-----------------------------------------------------------------------------------------------------------------**\
|                                                IMPORTANT NOTE:                                                      |
|                                                                                                                     |
| @GetMapping annotates the url where the user will go to initially or type into the browser                          |
| @ResponseBody only renders the information from the method in the controller. This is only ideal for testing        |
| Use the model object to add attributes that will be used on the viewer templates when called with thymeleaf         |
|                                                                                                                     |
|       --------------------------------------------------------------------------------------------------            |
|                                                                                                                     |
| The original structure of the postsIndex method will continue to add content to the page each time to repeat        |
| unless you create a method that allows you to add a post to an existing list and return that list each time.        |
| This will allow the functionality to update a list without it appending each time.                                  |
|                                                                                                                     |
| ex: return posts; / vs / return posts + post;                                                                       |
/**_________________________________________________________________________________________________________________**/


/**---------------------------------------------------------------------------------------------------------------------**\
|                                         POSTS INDEX METHOD: FIND ALL POSTS                                              |
|                                                                                                                         |
| 1) Direct the user to the url homepage using GetMapping annotation                                                      |
| 2) create a public String type method that uses a Model object parameter                                                |
| 3) use the .addAttribute method on the model parameter                                                                  |
| 4) the first parameter in the .addAttribute method identifies what the template will call the object (posts)            |
| 5) the second parameter identifies what the object will be; since we are using a services property for functionality    |
| 6) use findAll method, located in the services class, on the services property, which will return an array list of posts|
| 7) direct the user to the pathway on the server; the user only sees the information rendered on the /post url similar to|
|    WEB-INF directory in the MVC model                                                                                   |
/**_____________________________________________________________________________________________________________________**/

    @GetMapping("/posts")
    public String postsIndex(Model viewModel){
        viewModel.addAttribute("posts", postSvc.findAll());
        return "posts/index";
    }


/**-------------------------------------------------------------------------------------------------------------------**\
|                                  INDIVIDUAL POST METHOD: FIND ONE PARTICULAR POST                                     |
|                                                                                                                       |
| 1) Use @GetMapping to direct the user to a post based on the "id" property that is located in the array list          |
| 2) Create a public String type method that takes the id of the post and a Model Object parameter                      |
| 3) Use the @PathVariable annotation, to retrieve the id property from the Post class                                  |
| 4) use the .addAttribute method similar to the previous method; instead use .findOne() and place in the id parameter  |
| 5) Direct the user to the template that shows only one post at a time                                                 |
|                                                                                                                       |
\** __________________________________________________________________________________________________________________**/


    @GetMapping("/posts/{id}")
    public String individualPost(@PathVariable int id, Model viewModel){
        viewModel.addAttribute("post", postSvc.findOne(id));
        return "posts/show";
    }


    /**
     *                      SHOW FORM METHOD: Display a form to allow post creation
     *
     *
     */


    @GetMapping("/posts/create")
    public String showForm(Model viewModel){
        viewModel.addAttribute("post", new Post());
        return "posts/create";
    }


/**--------------------------------------------------------------------------------------------------------------------**\
|                           CREATED POST METHOD: Display the created post                                                |
|                                                                                                                        |
| this will take the object that was created from showForm method and pass it as the parameter                           |
| the @ModelAttribute allows me to use the object  and retrieve pieces from that object instead of passing each          |
| piece as a parameter.                                                                                                  |
|                                                                                                                        |
| 1) Use the @PostMapping annotation to direct user to the create page,                                                  |
| 2) Create a public String type method that takes a post object as a parameter                                          |
| 3) Use the @ModelAttribute annotation on the parameter                                                                 |
| 4) use save method (from PostsServices) on the services property and save the post to the end of the posts array list  |
| 5) redirect the user back to the posts homepage.                                                                       |
|                                                                                                                        |
| EXTRA: if you wanted to redirect to the post you just created:                                                         |
| 6) create a Post variable and assign step 4 to the variable                                                            |
| 7) in step 5 concat the Post variable and use the .getId() method to get the specific id number;                       |
|    similar to the url on the individual post method                                                                    |
/**____________________________________________________________________________________________________________________**/

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        postSvc.save(post);
//        Post savedPost = postSvc.save(post);
        return "redirect:/posts/" //+ savedPost.getId()
        ;
    }

    //this sees the form first
    @GetMapping("/posts/{id}/edit")
//    @ResponseBody

    //to update the form you have to know which id (parameter) you are looking for
    public String showUpdateForm(@PathVariable int id, Model viewModel){
        viewModel.addAttribute("post", postSvc.findOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
//    @ResponseBody

    //to update the form you have to know which id (parameter) you are looking for
    public String updateForm(@ModelAttribute Post post){
        Post updatedPost = postSvc.update(post);
        return "redirect:/posts/" + updatedPost.getId();
    }





}
