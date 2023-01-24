package com.axl.demo.kafka.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.axl.demo.kafka.config.Constants.Topics.*;

@Configuration
@RequiredArgsConstructor
public class KafkaTopicConfiguration {

    private final KafkaConfigProperties kafkaConfigProperties;

    @Bean
    public NewTopic likeTopic() {

        var partitions = kafkaConfigProperties.getLikeTopicPartitions();

        return TopicBuilder.name(LIKE_TOPIC)
                           .partitions(partitions)
                           .replicas(1)
                           .build();
    }

    @Bean
    public NewTopic greetTopic() {

        var partitions = kafkaConfigProperties.getGreetTopicPartitions();

        return TopicBuilder.name(GREET_TOPIC)
                           .partitions(partitions)
                           .replicas(1)
                           .build();
    }

    @Bean
    public NewTopic abuseTopic() {

        var partitions = kafkaConfigProperties.getAbuseTopicPartitions();

        return TopicBuilder.name(ABUSE_TOPIC)
                           .partitions(partitions)
                           .replicas(1)
                           .build();
    }
}
