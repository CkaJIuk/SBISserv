package ru.ckajiuk.SBISserv.Services;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public boolean verifyPassword(String username, String password){
        return username.equals("user") && password.equals("user");
    }
}
