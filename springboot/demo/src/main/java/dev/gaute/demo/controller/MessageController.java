package dev.gaute.demo.controller;

import dev.gaute.demo.publisher.RabbitMQPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/request")
public class MessageController {

    private RabbitMQPublisher publisher;

    public MessageController(RabbitMQPublisher publisher)
    {
        this.publisher=publisher;
    }

    //
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        publisher.sendMessage(message);
        System.out.println(message);
        return ResponseEntity.ok("Message sent");
    }
}
