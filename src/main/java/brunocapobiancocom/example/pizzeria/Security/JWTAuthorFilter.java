package brunocapobiancocom.example.pizzeria.Security;

import brunocapobiancocom.example.pizzeria.Entities.Users;
import brunocapobiancocom.example.pizzeria.Exceptions.UnauthorizedException;
import brunocapobiancocom.example.pizzeria.Services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.UUID;
import java.util.stream.Stream;

@Component
public class JWTAuthorFilter extends OncePerRequestFilter
{
    @Autowired
    private JWTTools jwtTools;
    @Autowired
    private UserService userService;
    private static final AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException
    {
        String authHeader=request.getHeader("Authorization");
        if(authHeader==null || !authHeader.startsWith("Bearer"))
        {
            throw new UnauthorizedException("inserire il token");
        }
        else
        {
            String accessToken=authHeader.substring(7);
            jwtTools.verifyToken(accessToken);
            String id=jwtTools.extractIdFromToken(accessToken);
            Users user=userService.findById(UUID.fromString(id));
            Authentication authentication= new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            filterChain.doFilter(request,response);
        }
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String[] allowedPaths = {"/auth/**", "/menu","/menu/type" };

        return Stream.of(allowedPaths)
                .anyMatch(path -> pathMatcher.match(path, request.getServletPath()));
    }
}

