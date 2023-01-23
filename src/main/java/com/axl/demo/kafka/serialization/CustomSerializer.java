package com.axl.demo.kafka.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;

public class CustomSerializer<T> implements Serializer<T> {

  private final ObjectMapper objectMapper;

  public CustomSerializer() {
    this.objectMapper = new ObjectMapper();
    this.objectMapper.registerModule(new JavaTimeModule());
  }

  @SneakyThrows
  @Override
  public byte[] serialize(String topic, T data) {
    return objectMapper.writeValueAsString(data).getBytes(StandardCharsets.UTF_8);
  }
}
