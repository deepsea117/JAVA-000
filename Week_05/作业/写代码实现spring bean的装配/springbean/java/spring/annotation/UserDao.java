package spring.annotation;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public User getUser(){
        User user = new User(2,"大明",40);
        return user;
    }
}
