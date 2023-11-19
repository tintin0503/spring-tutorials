package org.tintin.kafkaexample.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "tintin",
            groupId = "groupId"
    )
    void listener(String data) {
        System.out.println("Listener received: " + data + " !!!!!");
    }
}
