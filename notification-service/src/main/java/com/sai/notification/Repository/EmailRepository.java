package com.sai.notification.Repository;

import com.sai.notification.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByOrderId(String orderId);
}
