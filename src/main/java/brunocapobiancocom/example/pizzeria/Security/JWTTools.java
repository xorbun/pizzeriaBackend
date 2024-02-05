package brunocapobiancocom.example.pizzeria.Security;

import brunocapobiancocom.example.pizzeria.Entities.Users;
import brunocapobiancocom.example.pizzeria.Exceptions.UnauthorizedException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTTools
{
    @Value("${spring.jwt.secret}")
    private String secret;
    private String createToken(Users user)
    {
        return Jwts.builder().subject(String.valueOf(user.getIdUser()))
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*60*24*7))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }
    public void verifyToken(String token)
    {
        try
        {
            Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).build();
        }
        catch (Exception ex)
        {
            throw new UnauthorizedException("problemi con il token! Effettua il login");
        }
    }
    public String extractIdFromToken(String token)
    {
        return Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secret.getBytes())).build()
                .parseSignedClaims(token)
                .getPayload().getSubject();
    }
}
