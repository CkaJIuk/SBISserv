package ru.ckajiuk.SBISserv.Repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.ckajiuk.SBISserv.Entities.Order;

import java.util.List;

public interface OrdersRepo extends MongoRepository<Order, ObjectId> {
    List<Order> findOrdersByCustomerPhone(String CustomerPhone);
}
