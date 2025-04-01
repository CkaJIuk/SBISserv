package ru.ckajiuk.SBISserv.Repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.ckajiuk.SBISserv.Entities.Nomenclature;

import java.util.Optional;

public interface NomenclatureRepo extends MongoRepository<Nomenclature, ObjectId> {
    Optional<Nomenclature> findByPointIdAndPriceListId(int pointId, int priceListId);
}
