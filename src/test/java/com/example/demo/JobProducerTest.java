package com.example.demo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JobProducerTest {

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @InjectMocks
    private JobProducer jobProducer;

    @Test
    void submitJob_shouldSendMessageToKafka() {
        jobProducer.send("build-project");

        verify(kafkaTemplate, times(1))
                .send("jobs-topic", "build-project");
    }
}