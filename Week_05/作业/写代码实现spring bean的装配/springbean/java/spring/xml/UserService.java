package spring.xml;

public class UserService {

    private UserDao userDao;

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
