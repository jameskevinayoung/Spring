package com.codeup.springblog.Repository;

import com.codeup.springblog.Services.Post;
import org.springframework.data.repository.CrudRepository ;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends CrudRepository <Post, Integer> {
//select * from posts where title = 'X'; where title like
    List<Post> findAllByTitle(String term); //List<Post> findAllByTitleContains(String str);
    List<Post> findAllByTitleOrBodyContains(String term);
}
