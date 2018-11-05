package com.codeup.springblog.Services;

import com.codeup.springblog.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository <User, Integer> {
    User findByUsername(String username);

}
