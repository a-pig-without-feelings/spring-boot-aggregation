package com.roadhog;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringBootMQConsumerApplication.class)
@RabbitListener(queuesToDeclare = @Queue("hello"))
class SpringBootMqConsumerApplicationTests {

    @Test
    void contextLoads() {

    }

    @RabbitHandler
    public void receive(String message) {
        System.out.println("message: " + message);
    }

}
