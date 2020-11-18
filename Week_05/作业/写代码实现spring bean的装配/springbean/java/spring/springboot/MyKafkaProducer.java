package spring.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import spring.annotation.User;

@Component
public class MyKafkaProducer {

    private final static String TOPIC = "adienTest2";

    @Autowired
    private KafkaTemplate kafkaTemplate;


    public void send(){
        User u = new User(5, "大宝", 11);
        kafkaTemplate.send(TOPIC, u.toString());
    }

}
