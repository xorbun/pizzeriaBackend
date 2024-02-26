package brunocapobiancocom.example.pizzeria.Services;

import brunocapobiancocom.example.pizzeria.Entities.ROLE;
import brunocapobiancocom.example.pizzeria.Entities.Users;
import brunocapobiancocom.example.pizzeria.Exceptions.BadRequestException;
import brunocapobiancocom.example.pizzeria.Exceptions.UnauthorizedException;
import brunocapobiancocom.example.pizzeria.Payloads.UserLoginDTO;
import brunocapobiancocom.example.pizzeria.Payloads.UsersDTO;
import brunocapobiancocom.example.pizzeria.Repositories.UsersDAO;
import brunocapobiancocom.example.pizzeria.Security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService
{
    @Autowired
    private UserService userService;
    @Autowired
    private JWTTools jwtTools;
    @Autowired
    private UsersDAO usersDAO;
    @Autowired
    private PasswordEncoder bcrypt;

    public String Authenticator(UserLoginDTO body)
    {
        Users user=userService.findByEmail(body.email());
        if(bcrypt.matches(body.password(), user.getPassword()))
        {
            return jwtTools.createToken(user);
        }
        else
        {
            throw new UnauthorizedException("password errata");
        }
    }
    public Users save(UsersDTO body)
    {
        usersDAO.findByEmail(body.email()).ifPresent(users ->
        {
            throw new BadRequestException("L' email "+ users.getEmail()+" é già in uso");
        });
        Users newUser=new Users();
        newUser.setNome(body.nome());
        newUser.setCognome(body.cognome());
        newUser.setNickname(body.nickname());
        newUser.setAddress(body.address());
        newUser.setEmail(body.email());
        newUser.setPassword(bcrypt.encode(body.password()));
        newUser.setRole(ROLE.USER);
        return usersDAO.save(newUser);
    }
}
