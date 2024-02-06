package brunocapobiancocom.example.pizzeria.Services;

import brunocapobiancocom.example.pizzeria.Entities.Users;
import brunocapobiancocom.example.pizzeria.Exceptions.NotFoundException;
import brunocapobiancocom.example.pizzeria.Payloads.UsersDTO;
import brunocapobiancocom.example.pizzeria.Repositories.UsersDAO;
import brunocapobiancocom.example.pizzeria.Security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService
{
    @Autowired
    private UsersDAO usersDAO;
    @Autowired
    private JWTTools jwtTools;
    @Autowired
    private PasswordEncoder bcrypt;

    public Page <Users> Getusers(int page,int size,String orderBy)
    {
        if(size>=100)size=100;
        Pageable pageable= PageRequest.of(page,size, Sort.by(orderBy));
        return usersDAO.findAll(pageable);
    }
    public  Users findById(UUID idUser)
    {
       return usersDAO.findById(idUser).orElseThrow(()->new NotFoundException(idUser));
    }
    public Users findByIdAndUpdate(UUID idUser, UsersDTO body)
    {
        Users found=this.findById(idUser);
        found.setNome(body.nome());
        found.setCognome(body.cognome());
        found.setNickname(body.nickname());
        found.setPassword(bcrypt.encode(body.password()));
        return usersDAO.save(found);
    }
    public void findByIdAndDelete(UUID idUser)
    {
        Users found=this.findById(idUser);
        usersDAO.delete(found);
    }
    public Users findByEmail(String email)
    {
        return usersDAO.findByEmail(email).orElseThrow(()->new NotFoundException(email));
    }
}
