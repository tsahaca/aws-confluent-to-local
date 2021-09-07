package org.example.spring.avro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAvroApplication {


  /**
   * @Value("${topic.name}")
   *   private String topicName;
  @Value("${topic.partitions-num}")
  private Integer partitions;

  @Value("${topic.replication-factor}")
  private short replicationFactor;
*/
  public static void main(String[] args) {
    SpringApplication.run(SpringAvroApplication.class, args);
  }
/**
  @Bean
  NewTopic moviesTopic() {
    return new NewTopic(topicName, partitions, replicationFactor);
  }
  */
}


