package brunocapobiancocom.example.pizzeria.Controllers;

import brunocapobiancocom.example.pizzeria.Entities.Users;
import brunocapobiancocom.example.pizzeria.Payloads.UsersDTO;
import brunocapobiancocom.example.pizzeria.Services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsersController
{
    @Autowired
    private UserService userService;

    @GetMapping
    public Page<Users> getUsers(@RequestParam(defaultValue = "0")int page,
                                @RequestParam(defaultValue = "10")int size,
                                @RequestParam(defaultValue = "nickname")String orderBy)
    {
        return userService.Getusers(page,size,orderBy);
    }
    @GetMapping("/me")
    public Users getLoginData(@AuthenticationPrincipal Users user)
    {
        return userService.findById(user.getIdUser());
    }
    @PutMapping("/me/modify")
    public Users modifyUser(@AuthenticationPrincipal Users user,@RequestBody UsersDTO modifyUserPayload)
    {
        return userService.findByIdAndUpdate(user.getIdUser(),modifyUserPayload);
    }
    @GetMapping("/{idUser}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Users getUserById(@PathVariable UUID idUser)
    {
        return userService.findById(idUser);
    }
    @PutMapping("/{idUser}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Users findByIdAndUpdate(@PathVariable UUID idUser, @RequestBody UsersDTO modifyUserPayload)
    {
        return userService.findByIdAndUpdate(idUser,modifyUserPayload);
    }
    @DeleteMapping("/{idUser}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void findByIdAndDelete(@PathVariable UUID idUser,@RequestBody UsersDTO newUserPayload)
    {
        userService.findByIdAndDelete(idUser);
    }
}
