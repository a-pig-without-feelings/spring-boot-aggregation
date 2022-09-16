package com.roadhog.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*RabbitMQ配置文件*/
@Configuration
public class RabbitAdminConfig {

    public static String exchangeName = "EXCHANGE_TOPIC";

    public static String queueName = "QUEUE_TOPIC";

    //1.交换机
    @Bean("exchange")
    public Exchange exchange() {
        return ExchangeBuilder.topicExchange(exchangeName).durable(true).build();
    }


    //2.队列
    @Bean("queue")
    public Queue queue() {
        return QueueBuilder.durable(queueName).build();
    }

    //3.绑定关系
    @Bean
    public Binding binding(@Qualifier("queue") Queue queue, @Qualifier("exchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("boot.#").noargs();
    }

}
