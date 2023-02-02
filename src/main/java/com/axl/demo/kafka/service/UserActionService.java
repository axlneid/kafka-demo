package com.axl.demo.kafka.service;

import com.axl.demo.kafka.model.AbuseEvent;
import com.axl.demo.kafka.model.GreetEvent;
import com.axl.demo.kafka.model.LikeEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.axl.demo.kafka.config.Constants.Topics.*;

@Service
@RequiredArgsConstructor
public class UserActionService {
    private final KafkaTemplate<String, LikeEvent> likeEventKafkaTemplate;

    private final KafkaTemplate<String, GreetEvent> greetEventKafkaTemplate;

    private final KafkaTemplate<String, AbuseEvent> abuseEventKafkaTemplate;

    public void sendLikeEvent(LikeEvent likeEvent) {
        likeEventKafkaTemplate.send(LIKE_TOPIC, likeEvent);
    }

    public void sendGreetEvent(GreetEvent greetEvent) {
        greetEventKafkaTemplate.send(GREET_TOPIC, greetEvent);
    }

    public void sendAbuseEvent(AbuseEvent abuseEvent) {
        abuseEventKafkaTemplate.send(ABUSE_TOPIC, abuseEvent);
    }
}
