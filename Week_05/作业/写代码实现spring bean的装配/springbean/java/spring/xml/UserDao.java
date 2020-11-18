package spring.xml;

public class UserDao {

    public User getUser(){
        User user = new User(1,"小明",30);
        return user;
    }
}
