package ru.nova.consumer.service;

import ru.nova.consumer.domain.Order;
import ru.nova.consumer.service.dto.OrderDto;

public interface OrderService {
    Order save(OrderDto clientDto);
}
