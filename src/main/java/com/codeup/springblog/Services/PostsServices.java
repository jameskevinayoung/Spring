package com.codeup.springblog.Services;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;



//@Service annotation identifies the class as an intermediary between the controller and the templates to handle functionality.

@Service
public class PostsServices {

    //creating a property that is a list of posts
    private List<Post> posts;

    //constructor that creates an array list from the list of posts
    public PostsServices() {
        posts = new ArrayList<>();
        createPosts();
    }

    /**
     * this method finds a post by the id property of a Post object, takes the array list of posts and searches
     * for the id number (that starts with 1) and subtracts 1 to get the index (which starts with 0) of the array list
     */
    public Post findOne(int id){
        return posts.get(id-1);
    }


    //this method returns all of the posts in the array list

    public List<Post> findAll(){
        return posts;
    }

    /**
     * this method takes a post and sets the id to 1 number greater than the size of the posts array list
     * and adds it to the end of the current list, then returns that post.
     *
     */

    public Post save(Post post){
        post.setId(posts.size()+1);
        posts.add(post);
        return post;
    }

    /**
     * this method uses the add method for each new instance of a post to be created, uses the Post constructor that takes in the
     * the title and body parameters to construct a post. This is void because you are not specifically returning anything, just
     * creating the information that will be pulled somewhere else to be displayed on the webpage.
     * these posts could be added directly into the constructor instead of the createPosts method.
     */
    private void createPosts(){
        this.save(new Post("My First Post", "I'm sick of this shit"));
        this.save(new Post("A good day", "to learn code"));
        this.save(new Post("A bad day", "to learn code on an empty stomach"));

    }

    public Post update(Post post){
       return posts.set((int)post.getId()-1, post);

    }

}

