package com.codeup.springblog.Services;

import org.springframework.data.repository.CrudRepository ;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends CrudRepository <Post, Integer> {
//select * from posts where title = 'X'; where title like
//    List<Post> findAllByTitle(String term); //List<Post> findAllByTitleContains(String str);
    List<Post> findAllByTitleContainsOrBodyContains(String term, String term2);
}
