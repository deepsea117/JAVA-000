package spring.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringConfiguration {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(UserConfiguration.class);
        UserService userService = ctx.getBean(UserService.class);
    //    User user = userService.getUser();
        User user = userService.getUser2();
        System.out.println(user.toString());
    }
}
