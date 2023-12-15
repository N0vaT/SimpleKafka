package ru.nova.consumer.domain.repository;

import org.springframework.stereotype.Repository;
import ru.nova.consumer.domain.Order;

public interface OrdersRepository {

    void save(Order order);
}
