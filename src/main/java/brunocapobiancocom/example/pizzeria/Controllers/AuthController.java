package brunocapobiancocom.example.pizzeria.Controllers;

import brunocapobiancocom.example.pizzeria.Entities.Users;
import brunocapobiancocom.example.pizzeria.Exceptions.BadRequestException;
import brunocapobiancocom.example.pizzeria.Payloads.UserLoginDTO;
import brunocapobiancocom.example.pizzeria.Payloads.UserLoginResponseDTO;
import brunocapobiancocom.example.pizzeria.Payloads.UsersDTO;
import brunocapobiancocom.example.pizzeria.Payloads.UsersResponseDTO;
import brunocapobiancocom.example.pizzeria.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

@RestController
@RequestMapping("/auth")
public class AuthController
{
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public UserLoginResponseDTO login(@RequestBody UserLoginDTO body)
    {
        String accessToken=authService.Authenticator(body);
        return new UserLoginResponseDTO(accessToken);
    }
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UsersResponseDTO createUser(@RequestBody @Validated UsersDTO body,BindingResult validation)
    {
        System.out.println(validation);
        if(validation.hasErrors())
        {
            System.out.println(validation.getAllErrors());
            throw new BadRequestException("ci sono errori nel payloads");
        }
        else
        {
            Users newUser= authService.save(body);
            return new UsersResponseDTO(newUser.getIdUser());
        }
    }

}
