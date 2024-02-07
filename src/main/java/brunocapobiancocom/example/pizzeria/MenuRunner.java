package brunocapobiancocom.example.pizzeria;

import brunocapobiancocom.example.pizzeria.Entities.Menu;
import brunocapobiancocom.example.pizzeria.Entities.TYPE;
import brunocapobiancocom.example.pizzeria.Repositories.MenuDAO;
import brunocapobiancocom.example.pizzeria.Services.MenuService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Scanner;

@Component
@Order(3)
public class MenuRunner implements CommandLineRunner
{
    @Autowired
    private MenuDAO menuDAO;
    Faker faker=new Faker(new Locale("it"));
    @Override
    public void run(String... args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        boolean errors = false;
        do {
            System.out.println("Vuoi Procedere Con la Creazione del menu? (y/n)");
            String choice = scanner.nextLine();
            switch (choice.toLowerCase()) {
                case "y" -> {
                    createFood();
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
    public void createFood()
    {
        Menu pizza1=new Menu("margherita","wefdoihjoeir",4.50, TYPE.PIZZA);
        Menu pizza2= new Menu("marinara","efwiojweiofh",3.50,TYPE.PIZZA);
        Menu pizza3=new Menu("diavola","eruohifurheuh",6.50,TYPE.PIZZA);
        Menu pizza4=new Menu("capricciosa","feuhfiurhfiu",7.50,TYPE.PIZZA);
        Menu pizza5=new Menu("4 stagioni","reiohgoeriheor",7.50,TYPE.PIZZA);
        Menu pizza6=new Menu("4 formaggi","weoufhuewfheouwf",8.0,TYPE.PIZZA);
        Menu antipasto1=new Menu("patatine","eofhohforwehfo",1.50,TYPE.ANTIPASTI);
        Menu antipasto2=new Menu("arancini","ehfoewhfeoiwfhewo",1.50,TYPE.ANTIPASTI);
        Menu antipasto3=new Menu("crocchette","wefohweioewf",1.50,TYPE.ANTIPASTI);
        Menu bevanda1=new Menu("coca cola","efwfheowfheo",2.50,TYPE.BEVANDE);
        Menu bevanda2= new Menu("birra","iefhewifhewif",2.50,TYPE.BEVANDE);
        Menu bevanda3=new Menu("acqua","oefiwhoefh",1.50,TYPE.BEVANDE);
        menuDAO.save(pizza1);
        menuDAO.save(pizza2);
        menuDAO.save(pizza3);
        menuDAO.save(pizza4);
        menuDAO.save(pizza5);
        menuDAO.save(pizza6);
        menuDAO.save(antipasto1);
        menuDAO.save(antipasto2);
        menuDAO.save(antipasto3);
        menuDAO.save(bevanda1);
        menuDAO.save(bevanda2);
        menuDAO.save(bevanda3);

    }
}
