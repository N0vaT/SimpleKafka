package ru.nova.consumer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private String productName;
    private String barCode;
    private int quantity;
    private BigDecimal price;
    private BigDecimal amount;
    private LocalDateTime orderDate;
    private Status status;
}
