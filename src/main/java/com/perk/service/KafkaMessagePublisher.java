package com.perk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String,Object> template;

    public void sendMessageToTopic(String message) {
      CompletableFuture<SendResult<String,Object>> future = template.send("test-communication",message);
      future.whenComplete((result,exception)->{
          if (exception == null) {
              System.out.println("Sent Message = [" + message + "] with offset = [" +result.getRecordMetadata().offset() + "]");
          } else {
              System.out.println("Unable to Send Message = [" + message + "] due to : [" + exception.getMessage() + "]");
          }
      });
    }

}
