package org.example.spring.avro;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@CommonsLog(topic = "LocalDAPProducer Logger")
@Slf4j
public class KafkaProducerLocal {

  @Autowired
  @Qualifier("kafkaPropertiesLocal")
  private KafkaProperties kafkaProperties;

  //private  KafkaProducer<String, GenericRecord> producer;
  private  KafkaProducer<String, Object> producer;



  @PostConstruct
  public void initializeProducer(){
    producer = new KafkaProducer<>(kafkaProperties.buildProducerProperties());
  }


  public void sendMessage(final String topic, final String key, final GenericRecord payLoad){
    log.info(String.format("Sending Kafka message to topic=%s  with key=%s", topic, key));
    producer.send(new ProducerRecord<>(topic, key, payLoad));

  }

  public String  sendUser(User user) {
    producer.send(new ProducerRecord<>("users", user.getName(), user));

    //this.kafkaTemplate.sendDefault(user.getName(), user);
    log.info(String.format("Produced user -> %s", user));

    return "Success";
  }

}
