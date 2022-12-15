package com.vodinhminhquang.config;

import com.vodinhminhquang.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "vodinhminhquang",
            groupId = "groupId",
            containerFactory = "messageFactory"
    )
    void listener(Message data) {
        System.out.println("Listener received: " + data.message() + "!!!");
    }

}
