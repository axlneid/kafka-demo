package com.axl.demo.kafka.serialization;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Deserializer;

public class CustomDeserializer<T> implements Deserializer<T> {

  private final ObjectMapper objectMapper;
  final Class<T> typeParameterClass;

  public CustomDeserializer(Class<T> typeParameterClass) {
    this.typeParameterClass = typeParameterClass;
    this.objectMapper =
        new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    this.objectMapper.registerModule(new JavaTimeModule());
  }

  @SneakyThrows
  @Override
  public T deserialize(String topic, byte[] data) {
    return objectMapper.readValue(data, typeParameterClass);
  }
}
