package com.axl.demo.kafka.config;

import com.axl.demo.kafka.serialization.CustomDeserializer;
import com.axl.demo.kafka.serialization.CustomSerializer;
import lombok.Data;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "com.eon.smexnet.kafka.config")
public class KafkaConfigProperties {

    private String bootstrapAddress;
    private String saslJaasConfig;
    private boolean saslJaasConfigEnabled = true;
    private boolean batchEnabled = false;

    private int maxPollRecords = 50;
    private int receiveBufferBytes = 10000000;
    private int fetchMinBytes = 40000000;
    private int fetchMaxBytes = 50000000;
    private int fetchMaxWaitMs = 300;
    private int maxPartitionFetchBytes = 50000000;
    private int maxProducerRequestSize = 50000000;

    public Map<String, Object> getProducerProps() {

        Map<String, Object> producerProps = new HashMap<>();

        producerProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        producerProps.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, maxProducerRequestSize);
        producerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CustomSerializer.class);

        return producerProps;

    }

    public Map<String, Object> getConsumerProps() {

        Map<String, Object> consumerProps = new HashMap<>();

        consumerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        consumerProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, CustomDeserializer.class);

        consumerProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        if (isBatchEnabled()) {
            consumerProps.put(ConsumerConfig.FETCH_MIN_BYTES_CONFIG, fetchMinBytes);
            consumerProps.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, fetchMaxBytes);
            consumerProps.put(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG, fetchMaxWaitMs);
            consumerProps.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
            consumerProps.put(ConsumerConfig.RECEIVE_BUFFER_CONFIG, receiveBufferBytes);
            consumerProps.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG,
                              maxPartitionFetchBytes);
        }

        return consumerProps;
    }
}
