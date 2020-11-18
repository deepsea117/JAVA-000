package spring.annotation;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnotation {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("springpackagescan.xml");
    //    UserService userService = (UserService) ctx.getBean("userService");
        UserService userService = ctx.getBean(UserService.class);
        User user = userService.getUser();
        System.out.println(user.toString());

    }
}
