package org.example.spring.avro;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog(topic = "Producer Logger")
public class Producer {

  /**
   *
   @Value("${topic.name}")
   private String TOPIC;
  private final KafkaTemplate<String, User> kafkaTemplate;

  @Autowired
  public Producer(KafkaTemplate<String, User> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }
 */



  private final KafkaTemplate<String, Object> kafkaTemplate;

  @Autowired
  public Producer(KafkaTemplate<String, Object> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(final String topic, final String key, final Object payLoad){
    log.info(String.format("Sending Kafka message to topic=%s  with key=%s", topic, key));
    kafkaTemplate.send(topic, key, payLoad);

  }
}
