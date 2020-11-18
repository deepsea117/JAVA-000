package spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    private UserDao userDao;

    @Autowired
    private UserRepository userRepository;

    public User getUser2(){
        return userRepository.getUser();
    }

    public User getUser(){
        return userDao.getUser();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
