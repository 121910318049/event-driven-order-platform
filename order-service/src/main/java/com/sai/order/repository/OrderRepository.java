package com.sai.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sai.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}