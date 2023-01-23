package com.axl.demo.kafka.config;


import com.axl.demo.kafka.model.GreetEvent;
import com.axl.demo.kafka.model.LikeEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class KafkaProducerConfiguration {

    private final KafkaConfigProperties kafkaConfigProperties;

    @Bean
    public KafkaTemplate<String, LikeEvent> likeEventKafkaTemplate() {
        return new KafkaTemplate<>(likeEventProducerFactory());
    }

    @Bean
    public ProducerFactory<String, LikeEvent> likeEventProducerFactory() {
        return new DefaultKafkaProducerFactory<>(kafkaConfigProperties.getProducerProps());
    }

    @Bean
    public KafkaTemplate<String, GreetEvent> greetEventKafkaTemplate() {
        return new KafkaTemplate<>(greetEventProducerFactory());
    }

    @Bean
    public ProducerFactory<String, GreetEvent> greetEventProducerFactory() {
        return new DefaultKafkaProducerFactory<>(kafkaConfigProperties.getProducerProps());
    }
}
