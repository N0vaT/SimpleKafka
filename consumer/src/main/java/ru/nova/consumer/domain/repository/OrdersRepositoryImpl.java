package ru.nova.consumer.domain.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ru.nova.consumer.domain.Order;

@Slf4j
@Repository
public class OrdersRepositoryImpl implements OrdersRepository {

    @Override
    public void save(Order order) {
        log.info("the order is saved in the database - {}", order);
    }
}
