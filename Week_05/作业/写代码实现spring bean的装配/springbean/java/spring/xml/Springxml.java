package spring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Springxml {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("springbeans.xml");
        UserService userService = ctx.getBean("userService", UserService.class);
        User user = userService.getUser();
        System.out.println(user.toString());

    }
}
