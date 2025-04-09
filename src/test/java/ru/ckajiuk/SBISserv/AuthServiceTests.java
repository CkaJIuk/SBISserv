package ru.ckajiuk.SBISserv;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ckajiuk.SBISserv.Entities.Client;
import ru.ckajiuk.SBISserv.Repositories.ClientsRepo;
import ru.ckajiuk.SBISserv.Services.AuthService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AuthServiceTests {

    @Test
    void contextLoads() {
    }

    @Mock
    private ClientsRepo clientsRepo;

    @InjectMocks
    private AuthService authService;

    @Test
    void loginTest() {
        given(clientsRepo.findByClientName("u123456"))
                .willReturn(Optional.of(new Client(new ObjectId(), "u123456", "$2a$10$IKOFdQ6sXBDieTb5I6FNJ.JgxJTRxqkJ17IpmtSd9JIu5/JTWkJ7e")));

        assertFalse(authService.verifyPassword("u123456", "qqq"));
        assertTrue(authService.verifyPassword("u123456", "$2a$10$IKOFdQ6sXBDieTb5I6FNJ.JgxJTRxqkJ17IpmtSd9JIu5/JTWkJ7e"));
        assertFalse(authService.verifyPassword("u31313", "$2a$10$IKOFdQ6sXBDieTb5I6FNJ.JgxJTRxqkJ17IpmtSd9JIu5/JTWkJ7e"));
    }
}
