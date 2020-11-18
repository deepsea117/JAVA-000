package spring.configuration;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public User getUser(){
        User user = new User(4,"大军",20);
        return user;
    }

}
