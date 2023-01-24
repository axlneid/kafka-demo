package com.axl.demo.kafka.web.rest;

import com.axl.demo.kafka.model.AbuseEvent;
import com.axl.demo.kafka.model.GreetEvent;
import com.axl.demo.kafka.model.LikeEvent;
import com.axl.demo.kafka.service.UserActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user-action")
@RequiredArgsConstructor
public class UserActionRestController {

    private final UserActionService userActionService;

    @GetMapping("/like/{name}")
    public String sendLikeEvent(@PathVariable String name) {

        var likeEvent = new LikeEvent(name);

        userActionService.sendLikeEvent(likeEvent);

        return "index";
    }

    @GetMapping("/greet/{name}")
    public String sendGreetEvent(@PathVariable String name) {

        var greetEvent = new GreetEvent(name);

        userActionService.sendGreetEvent(greetEvent);

        return "index";
    }


    @GetMapping("/abuse/{name}")
    public String sendAbuseEvent(@PathVariable String name) {

        var abuseEvent = new AbuseEvent(name);

        userActionService.sendAbuseEvent(abuseEvent);

        return "index";
    }
}
