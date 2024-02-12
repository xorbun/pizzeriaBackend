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
        Menu pizza1=new Menu("margherita","https://bing.com/th?id=OSK.32079802b7cf7a2df5512043bc80219a",4.50, TYPE.PIZZA);
        Menu pizza2= new Menu("marinara","https://cdn.shopify.com/s/files/1/0944/3476/articles/marinara-for-web.jpg?v=1593515321",3.50,TYPE.PIZZA);
        Menu pizza3=new Menu("diavola","https://th.bing.com/th/id/R.01aedf0ea683efaf995e5bdf3e815be0?rik=Ib1%2f2mcvB%2fmABg&pid=ImgRaw&r=0",6.50,TYPE.PIZZA);
        Menu pizza4=new Menu("capricciosa","https://th.bing.com/th/id/R.01aedf0ea683efaf995e5bdf3e815be0?rik=Ib1%2f2mcvB%2fmABg&pid=ImgRaw&r=0",7.50,TYPE.PIZZA);
        Menu pizza5=new Menu("4 stagioni","https://th.bing.com/th/id/OIP.EpbGXPoEjVslOKDhFZqwMwHaFn?rs=1&pid=ImgDetMain",7.50,TYPE.PIZZA);
        Menu pizza6=new Menu("4 formaggi","https://cdn.tasteatlas.com/images/dishes/e6f2310a7ffe4904bc9826bfc77ee11f.jpg",8.0,TYPE.PIZZA);
        Menu antipasto1=new Menu("patatine","https://th.bing.com/th/id/R.38e10e6073979527382115d9b5f3d56f?rik=9ROoADvujPvDKA&pid=ImgRaw&r=0",1.50,TYPE.ANTIPASTI);
        Menu antipasto2=new Menu("arancini","https://th.bing.com/th/id/OIP.ZcnTQTCt3PWscoAdr5nYsAHaE8?rs=1&pid=ImgDetMain",1.50,TYPE.ANTIPASTI);
        Menu antipasto3=new Menu("crocchette","https://www.alimentipedia.it/files/styles/main_image/public/images/crocchette-patate.jpg?itok=9zjgwNcU",1.50,TYPE.ANTIPASTI);
        Menu bevanda1=new Menu("coca cola","https://th.bing.com/th/id/OIP.8qV2gQfYfyYsN5LvIfNnLwHaFj?rs=1&pid=ImgDetMain",2.50,TYPE.BEVANDE);
        Menu bevanda2= new Menu("birra","https://wallpapercave.com/wp/wp3087049.jpg",2.50,TYPE.BEVANDE);
        Menu bevanda3=new Menu("acqua","https://th.bing.com/th/id/R.427a1740aa5f2534aa0336e733ea11fa?rik=hyvns%2fy%2bR0AHxA&pid=ImgRaw&r=0&sres=1&sresct=1",1.50,TYPE.BEVANDE);
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
