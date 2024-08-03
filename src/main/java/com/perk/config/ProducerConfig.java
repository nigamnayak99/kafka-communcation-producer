package com.perk.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfig {

    @Bean
    public NewTopic createNewTopic(){
        return new NewTopic("new-test", 5, (short)1);
    }
}
