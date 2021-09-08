package org.example.spring.avro;


import org.example.spring.avro.util.DateUtil;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;


@SpringBootTest(classes = {DateUtil.class})
public class KafkaAvroApplicationTests {

	@Test
	public void contextLoads() {
	}

}
