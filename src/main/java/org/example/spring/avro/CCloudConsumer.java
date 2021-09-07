package org.example.spring.avro;


import lombok.extern.apachecommons.CommonsLog;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import static org.springframework.kafka.support.KafkaHeaders.RECEIVED_PARTITION_ID;



@Service
@CommonsLog(topic = "CCloudConsumer Logger")
public class CCloudConsumer {

  private static int COUNT;

  @Autowired
  private KafkaProducerLocal kafkaProducerLocal;

  @Value("${application.aws-source}")
  private String topic;

  //ByteArrayDeserializer

  @KafkaListener(topics = "${application.aws-source}", groupId = "${spring.kafka.consumer.group-id}")
  public void consume(ConsumerRecord<String, GenericRecord> record, @Header(RECEIVED_PARTITION_ID) Integer partitionId) {
    ++COUNT;
    log.info(String.format("Received No of GenericRecord=%s , key=%s, TaxLot=%s, from partition: %s",
            COUNT,  record.key(), record.value(), partitionId));
    kafkaProducerLocal.sendMessage(topic, record.key(), record.value());
  }
}