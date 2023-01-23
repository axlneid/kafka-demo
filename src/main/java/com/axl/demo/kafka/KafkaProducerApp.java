package com.axl.demo.kafka;

import com.axl.demo.kafka.config.KafkaConfigProperties;
import com.axl.demo.kafka.web.rest.UserActionRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = UserActionRestController.class)
@EnableConfigurationProperties({KafkaConfigProperties.class})
public class KafkaProducerApp {

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApp.class, args);
    }

}
