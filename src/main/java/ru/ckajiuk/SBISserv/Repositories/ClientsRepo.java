package ru.ckajiuk.SBISserv.Repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.ckajiuk.SBISserv.Entities.Client;

import java.util.Optional;

public interface ClientsRepo extends MongoRepository<Client, ObjectId> {
    Optional<Client> findByClientName(String client_name);
}
