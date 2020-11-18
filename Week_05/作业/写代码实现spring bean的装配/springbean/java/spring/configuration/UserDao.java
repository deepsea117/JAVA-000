package spring.configuration;

public class UserDao {

    public User getUser(){
        User user = new User(3,"小宝",10);
        return user;
    }
}
