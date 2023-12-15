package ru.nova.producer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.nova.producer.services.event.OrderSendEvent;

@Service
@RequiredArgsConstructor
public class KafkaMessagingService {

    @Value("${topic.send-order}")
    private String sendClientTopic;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendOrder(OrderSendEvent orderSendEvent){
        kafkaTemplate.send(sendClientTopic, orderSendEvent.getBarCode(), orderSendEvent);
    }
}
