package ru.nova.producer.services.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.nova.producer.models.Order;
import ru.nova.producer.services.KafkaMessagingService;
import ru.nova.producer.services.event.OrderSendEvent;

@Slf4j
@Component
@RequiredArgsConstructor
public class Producer {

    private final KafkaMessagingService kafkaMessagingService;
    private final ModelMapper modelMapper;

    public Order sendOrderEvent(Order order){
        kafkaMessagingService.sendOrder(modelMapper.map(order, OrderSendEvent.class));
        log.info("Send order from producer {}", order);
        return  order;
    }
}
