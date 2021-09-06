package org.example.spring.avro;


import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.annotation.EnableKafka;

import org.springframework.kafka.listener.LoggingErrorHandler;



@Configuration
@EnableKafka
public class KafkaConfiguration {

    /**
     * Boot will autowire this into the container factory.
     */
    @Bean
    public LoggingErrorHandler errorHandler() {
        return new LoggingErrorHandler();
    }

    @Bean
    @ConfigurationProperties(prefix="spring.kafka")
    @Primary
    public KafkaProperties kafkaProperties(){
        return new KafkaProperties();
    }

    @Bean("kafkaPropertiesLocal")
    @ConfigurationProperties(prefix="spring.kafka-local")
    public KafkaProperties kafkaPropertiesLocal(){
        return new KafkaProperties();
    }

}
