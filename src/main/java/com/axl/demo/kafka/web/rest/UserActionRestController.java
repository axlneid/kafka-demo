package com.axl.demo.kafka.web.rest;

import com.axl.demo.kafka.model.GreetEvent;
import com.axl.demo.kafka.model.LikeEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.axl.demo.kafka.config.Constants.Topics.GREET_EVENT_TOPIC;
import static com.axl.demo.kafka.config.Constants.Topics.LIKE_EVENT_TOPIC;

@Controller
@RequestMapping("/user-action")
@RequiredArgsConstructor
public class UserActionRestController {

    private final KafkaTemplate<String, LikeEvent> likeEventKafkaTemplate;

    private final KafkaTemplate<String, GreetEvent> greetEventKafkaTemplate;

    @GetMapping("/like/{name}")
    public String sendLikeEvent(@PathVariable String name) {
        likeEventKafkaTemplate.send(LIKE_EVENT_TOPIC, new LikeEvent(name));
        return "index";
    }

    @GetMapping("/greet/{name}")
    public String sendGreetEvent(@PathVariable String name) {
        greetEventKafkaTemplate.send(GREET_EVENT_TOPIC, new GreetEvent(name));
        return "index";
    }
}
