package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JobConsumer {
    @KafkaListener(topics = "jobs-topic", groupId = "group")
    public void consume(String msg) {
        System.out.println("Job: " + msg);
    }
}
