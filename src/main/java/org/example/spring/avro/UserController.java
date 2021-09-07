package org.example.spring.avro;


import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/user")
@CommonsLog(topic = "Controller Logger")
public class UserController {
  @Autowired
  private  Producer producer;

  @Autowired
  private KafkaProducerLocal kafkaProducerLocal;

  @PostMapping(value = "/createUser")
  public String createUser(@RequestParam("name") String name, @RequestParam("age") Integer age) {
    return this.kafkaProducerLocal.sendUser(new User(name, age));
  }

  @GetMapping(value = "/getenv")
  public String getEnv() {
    return System.getProperty("javax.net.ssl.trustStore");
  }

}