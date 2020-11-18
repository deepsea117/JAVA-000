package spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "spring.configuration")
public class UserConfiguration {

    @Bean
    public UserService getUserService(){
        UserService userService = new UserService();
    //    userService.setUserDao(new UserDao());
        return userService;
    }


}
