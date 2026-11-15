
package com.sai.order.repository;

import com.sai.order.exception.DuplicateOrderException;
import com.sai.order.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;

@Repository
public class HiberNateRepo {

    private final SessionFactory sessionFactory;

    public HiberNateRepo(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Fetch order by orderId
    public Order getOrderById(String orderId) {

        try (Session session = sessionFactory.openSession()) {

            return session.createQuery(
                            "FROM Order o WHERE o.orderId = :orderId",
                            Order.class)
                    .setParameter("orderId", orderId)
                    .uniqueResult();
        }
    }

    // Save order with transaction management
    public Order saveOrder(Order order) {

        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();

            session.persist(order);
            session.flush();

            transaction.commit();

            return order;

        } catch (Exception e) {

            System.out.println("6. ENTERED CATCH BLOCK");

            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            if (e instanceof ConstraintViolationException cve) {

                throw new DuplicateOrderException(
                        "Order already created: " + order.getOrderId()
                );
            }

            throw new RuntimeException("Failed to save order", e);
        }
    }




    // Update order using merge
    public Order updateOrder(Order order) {

        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();

            Order updatedOrder = session.merge(order);

            transaction.commit();

            return updatedOrder;

        } catch (Exception e) {

            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            throw new RuntimeException("Failed to update order", e);
        }
    }
}
