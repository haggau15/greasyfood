package dev.gaute.demo.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQPublisher {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQPublisher.class);
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;
    private RabbitTemplate template;

    public RabbitMQPublisher(RabbitTemplate template) {
        this.template = template;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Message sent ->%s", message));
        template.convertAndSend(exchange,routingKey,message);
    }

}
