package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import spring.springboot.MyKafkaProducer;

@SpringBootApplication
public class SpringHomeworkApplication {

    public static void main(String[] args) {

        /**
         * 运行springboot需要把pom文件中的spring配置删除
         */
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringHomeworkApplication.class, args);
        MyKafkaProducer producer = ctx.getBean(MyKafkaProducer.class);
        producer.send();
    }
}
