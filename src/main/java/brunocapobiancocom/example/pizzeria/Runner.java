package brunocapobiancocom.example.pizzeria;

import brunocapobiancocom.example.pizzeria.Entities.ROLE;
import brunocapobiancocom.example.pizzeria.Entities.Users;
import brunocapobiancocom.example.pizzeria.Repositories.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Scanner;

@Component
@Order(2)
public class Runner implements CommandLineRunner
{
    @Autowired
    private PasswordEncoder bcrypt;
    @Autowired
    private UsersDAO usersDAO;
    Faker faker=new Faker(new Locale("it"));
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean errors = false;
        do {
            System.out.println("Vuoi Procedere Con la Creazione Degli Utenti (y/n)");
            String choice = scanner.nextLine();
            switch (choice.toLowerCase()) {
                case "y" -> {
                    createAdmin();
                    createUsers();
                    errors = false;
                }
                case "n" -> errors = false;
                default -> {
                    System.out.println("Input non valido. Riprova.");
                    errors = true;
                }
            }
        } while (errors);
    }
    public void createAdmin()
    {
        String defaultPassword=bcrypt.encode("1234");
        Users Bruno=new Users("bruno","capobianco","xorbun","via solfatara 54","bruno@mail.it",defaultPassword, ROLE.ADMIN);
        usersDAO.save(Bruno);
    }
    public void createUsers()
    {
        for(int i=0;i<=30;i++)
        {
            String name=faker.funnyName().name();
            String cognome=faker.name().lastName();
            String nickname= faker.name().username();
            String address=faker.address().fullAddress();
            String email=faker.internet().emailAddress();
            String password=bcrypt.encode("1234");
            Users newUser=new Users();
            newUser.setNome(name);
            newUser.setCognome(cognome);
            newUser.setNickname(nickname);
            newUser.setAddress(address);
            newUser.setEmail(email);
            newUser.setPassword(password);
            newUser.setRole(ROLE.USER);
            usersDAO.save(newUser);
        }
    }

}
