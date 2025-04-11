package ru.ckajiuk.SBISserv.Components;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Component
@Getter
@Setter
@ConfigurationProperties("rsa")
public class RSAKeyProperties {
    private RSAPrivateKey privateKey;
    private RSAPublicKey publicKey;
}