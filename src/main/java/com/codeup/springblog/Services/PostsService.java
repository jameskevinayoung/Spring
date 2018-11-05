package com.codeup.springblog.Services;

import com.codeup.springblog.Models.Post;
import org.springframework.stereotype.Service;

import java.util.List;



//@Service annotation identifies the class as an intermediary between the controller
// and the templates to handle functionality.

@Service
public class PostsService {



     /**---------------------------------------------**\
     |              Dependency Injection               |
     \**______________________________________________*/

    private PostsRepository postsRepo;

    public PostsService(PostsRepository postsRepo){
        this.postsRepo =postsRepo;
    }


//--------------------- METHODS TO BE USED IN CONTROLLER -------------------------------\\

    //FIND ALL OF THE POSTS IN THE DATABASE
    public Iterable<Post> all() {
        return postsRepo.findAll();
    }

    //TAKE THE POST THAT WAS CREATED AND SAVE IT TO THE DATABASE
    public Post create(Post post) {
        return postsRepo.save(post);
    }

    //TAKE A CREATED POST BY ITS ID, EDIT THE TITLE/BODY AND UPDATE THE ROW TO SHOW NEW INFORMATION
    public Post edit(Post post) {
        return postsRepo.save(post);
    }

    //FIND AN INDIVIDUAL POST BY ITS ID
    public Post findIndividual(int id) {
        return postsRepo.findOne(id);
    }


    //SEARCH THROUGH THE DATABASE OF POSTS, FIND ALL POSTS WITH A SPECIFIC TERM IN EITHER THE TITLE OR BODY
    public List<Post> search(String term, String term2) {
        return postsRepo.findAllByTitleContainsOrBodyContains(term, term2);
    }

    //TAKE A POST AS A PARAMETER, SEARCH THE REPO (DATABASE) AND DELETE THE POST
    public void delete(Post post){
        postsRepo.delete(post);
    }
//    public List<Post> search(String term) {
//        return postsRepo.findAllByTitle(term);
//    }


//----------------------------------------------- NOT USING A DATABASE -----------------------------------------------\\

//    //creating a property that is a list of posts
//    private List<Post> posts;
//
//    //constructor that creates an array list from the list of posts
//    public PostsServices() {
//        posts = new ArrayList<>();
//        createPosts();
//    }
//
//
///**-----------------------------------------------------------------------------------------------------------------**\
//| this method finds a post by the id property of a Post object, takes the array list of posts and searches            |
//| for the id number (that starts with 1) and subtracts 1 to get the index (which starts with 0) of the array list     |
//\**-----------------------------------------------------------------------------------------------------------------**/
//    public Post findOne(int id){
//        return posts.get(id-1);
//    }
//
//
//    //this method returns all of the posts in the array list
//
//    public List<Post> findAll(){
//        return posts;
//    }
//
//
///**---------------------------------------------------------------------------------------------------**\
//| this method takes a post and sets the id to 1 number greater than the size of the posts array list    |
//| and adds it to the end of the current list, then returns that post.                                   |
//\**---------------------------------------------------------------------------------------------------**/
//
//    public Post save(Post post){
//        post.setId(posts.size()+1);
//        posts.add(post);
//        return post;
//    }
//
///**--------------------------------------------------------------------------------------------**\
//| this method uses the add method for each new instance of a post to be created,                 |
//| uses the Post constructor that takes in the the title and body parameters to construct a post. |
//| This is void because you are not specifically returning anything, just                         |
//| creating the information that will be pulled somewhere else to be displayed on the web page.   |
//| These posts could be added directly into the constructor instead of the createPosts method.    |
//\**--------------------------------------------------------------------------------------------**/
//    private void createPosts(){
//        this.save(new Post("My First Post", "I'm sick of this shit"));
//        this.save(new Post("A good day", "to learn code"));
//        this.save(new Post("A bad day", "to learn code on an empty stomach"));
//
//    }
//
//    public Post update(Post post){
//       return posts.set((int)post.getId()-1, post);
//
//    }


//--------------------------------------------------------------------------------------------------------------------\\
}

