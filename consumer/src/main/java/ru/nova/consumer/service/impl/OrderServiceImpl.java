package ru.nova.consumer.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.nova.consumer.domain.Order;
import ru.nova.consumer.domain.Status;
import ru.nova.consumer.domain.repository.OrdersRepository;
import ru.nova.consumer.service.OrderService;
import ru.nova.consumer.service.dto.OrderDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    private final OrdersRepository ordersRepository;

    @Override
    @Transactional
    public Order save(OrderDto clientDto) {

        Order order = Order.builder()
                .productName(clientDto.getProductName())
                .barCode(clientDto.getBarCode())
                .quantity(clientDto.getQuantity())
                .price(clientDto.getPrice())
                .amount(new BigDecimal(clientDto.getQuantity()).multiply(clientDto.getPrice()))
                .orderDate(LocalDateTime.now())
                .status(Status.APPROVED)
                .build();

        //ordersRepository.save(order);

        log.info("Save order");
        return order;
    }
}
