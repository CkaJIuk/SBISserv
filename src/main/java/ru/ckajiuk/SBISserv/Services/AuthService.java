package ru.ckajiuk.SBISserv.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ckajiuk.SBISserv.Entities.Client;
import ru.ckajiuk.SBISserv.Repositories.ClientsRepo;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private ClientsRepo clientsRepo;

    public boolean verifyPassword(String clientName, String clientSecret) {
        Optional<Client> client = clientsRepo.findByClientName(clientName);
        return client.isPresent() && client.get().getClientName().equals(clientName)
                && client.get().getClientSecret().equals(clientSecret);
    }
}
