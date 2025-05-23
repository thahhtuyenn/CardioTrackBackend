package vn.edu.iuh.fit.pay.jwt;

import io.jsonwebtoken.Claims;

import java.security.Key;

public interface JwtService {

    Claims extractClaims(String token);

    Key getKey();

    String getCurrentUser();

    String getUsernameFromToken(String token);

}
