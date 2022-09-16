package com.roadhog.mq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class RabbitMQListener {

    @RabbitListener(queues = "QUEUE_TOPIC")
    public void listenQueue(Message message){
        System.out.println(new String(message.getBody()));
    }
}
