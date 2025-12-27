package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

public class JobProducer {
	@Service
	public class JobProduce {
	    @Autowired
	    KafkaTemplate<String, String> kafkaTemplate;

	    public void send(String job) {
	        kafkaTemplate.send("jobs-topic", job);
	    }
	}
}
