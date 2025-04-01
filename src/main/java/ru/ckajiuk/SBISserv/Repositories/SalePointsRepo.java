package ru.ckajiuk.SBISserv.Repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.ckajiuk.SBISserv.Entities.SalePoint;

public interface SalePointsRepo extends MongoRepository<SalePoint, ObjectId> {
}
