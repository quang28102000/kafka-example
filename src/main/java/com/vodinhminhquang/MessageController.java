package com.vodinhminhquang;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    private KafkaTemplate<String, Message> kafkaTemplate;

    public MessageController(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // @RequestBody ~ transfer an object (deserialize automatically)
    // @RestController = @ResponseBody + @Controller
    // @ResponseBody ~ an object returned is automatically serialize into JSON object
    @PostMapping
    public void publish(@RequestBody MessageRequest request) {
        Message message = Message.builder().message(request.message()).created(LocalDateTime.now()).build();
        kafkaTemplate.send("vodinhminhquang", message);
    }

}
