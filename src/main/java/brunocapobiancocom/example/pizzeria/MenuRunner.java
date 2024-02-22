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
        Menu pizza1=new Menu("margherita","https://bing.com/th?id=OSK.32079802b7cf7a2df5512043bc80219a",4.50,"pomodoro,mozzarella,basilico", TYPE.PIZZA);
        Menu pizza2= new Menu("marinara","https://cdn.shopify.com/s/files/1/0944/3476/articles/marinara-for-web.jpg?v=1593515321",3.50," pomodoro, basilico,origano",TYPE.PIZZA);
        Menu pizza3=new Menu("diavola","https://th.bing.com/th/id/R.01aedf0ea683efaf995e5bdf3e815be0?rik=Ib1%2f2mcvB%2fmABg&pid=ImgRaw&r=0",6.50,"pomodoro,mozzarella,salame piccante",TYPE.PIZZA);
        Menu pizza4=new Menu("capricciosa","https://bing.com/th?id=OSK.b61fa628eb9ba01e618aa7183952a94d",7.50,"pomodoro,mozzarella,funghi,carciofini, acciughe",TYPE.PIZZA);
        Menu pizza5=new Menu("4 stagioni","https://th.bing.com/th/id/OIP.EpbGXPoEjVslOKDhFZqwMwHaFn?rs=1&pid=ImgDetMain",7.50,"funghi,prosciutto,olive,carciofi,pomodoro,basilico,mozzarella",TYPE.PIZZA);
        Menu pizza6=new Menu("4 formaggi","https://cdn.tasteatlas.com/images/dishes/e6f2310a7ffe4904bc9826bfc77ee11f.jpg",8.0,"mozzarella, gorgonzola,grana padano,fontina",TYPE.PIZZA);
        Menu pizza7=new Menu("tedesca","https://pizzeriagape.files.wordpress.com/2018/01/pizza-wurstel-con-patatine-e1515777059402.jpg?w=768",6.50,"mozzarella,wurstell,patatine fritte",TYPE.PIZZA);
        Menu pizza8=new Menu("tartufata","https://www.pizzapiu.net/wp-content/uploads/2017/03/tartufata-pizza-domicilio-benevento-600x400.jpg",8.00,"mozzarella, tartufo",TYPE.PIZZA);
        Menu pizza9=new Menu("boscaiola","https://th.bing.com/th/id/OIP.Nn_MkCmX67NL8YbeVErUPQHaE8?rs=1&pid=ImgDetMain",8.00,"mozzarella, funghi,salsiccia,pepe nero",TYPE.PIZZA);
        Menu pizza10=new Menu("prosciutto e funghi","https://www.newcroco.ro/image/cache/catalog/Prosciutto%20E%20Funghi%20(1600)-1000x700.jpg",7.50,"mozzarella, prosciutto cotto, funghi",TYPE.PIZZA);
        Menu antipasto1=new Menu("patatine","https://th.bing.com/th/id/R.38e10e6073979527382115d9b5f3d56f?rik=9ROoADvujPvDKA&pid=ImgRaw&r=0",1.50,"patate dolci fritte",TYPE.ANTIPASTI);
        Menu antipasto2=new Menu("arancini","https://th.bing.com/th/id/OIP.ZcnTQTCt3PWscoAdr5nYsAHaE8?rs=1&pid=ImgDetMain",2.00,"riso, pan grattato,sugo",TYPE.ANTIPASTI);
        Menu antipasto3=new Menu("montanara","https://www.agriturismolabrezza.it/wp-content/uploads/2020/05/antipasto.jpg",7.50,"affettati vari, formaggi vari",TYPE.ANTIPASTI);
        Menu antipasto4=new Menu("wurstell in camicia","https://th.bing.com/th/id/R.dc99bc6bacf05efec67a740030c3130e?rik=Fz%2fMOd6lUAACqg&pid=ImgRaw&r=0",2.50,"wurstell",TYPE.ANTIPASTI);
        Menu antipasto5=new Menu("olive all'ascolana","https://cdn.ilclubdellericette.it/wp-content/uploads/2020/02/olive-all-ascolana.jpg",2.50,"olive verdi,finocchietto,pangrattato",TYPE.ANTIPASTI);
        Menu antipasto6=new Menu("pizzette fritte","https://images.fidhouse.com/fidelitynews/wp-content/uploads/sites/6/2019/01/1548073160_593e4d5d3b9d8c94a853d29d80e8006cb23e132a-1548072724.jpg",2.50,"pomodoro,mozzarella, impasto fritto",TYPE.ANTIPASTI);
        Menu antipasto7=new Menu("mozzarella in carrozza","https://th.bing.com/th/id/OIP.tLkuBqVNlKgbjoQbYqkXUAHaEK?rs=1&pid=ImgDetMain",2.50,"mozzarella,pangrattato",TYPE.ANTIPASTI);
        Menu antipasto8=new Menu("bruschette","https://www.aiafood.com/sites/default/files/styles/scale_1920/public/articles/bruschette_invernali.jpg?itok=fNMeWfd6",4.50,"pane, pomodoro, olio",TYPE.ANTIPASTI);
        Menu antipasto9=new Menu("mozzarelline fritte","https://cdn.ilclubdellericette.it/wp-content/uploads/2020/02/mozzarelline-fritte.jpg",3.50,"mozzarella, pangrattato",TYPE.ANTIPASTI);
        Menu antipasto10=new Menu("crocchette","https://www.alimentipedia.it/files/styles/main_image/public/images/crocchette-patate.jpg?itok=9zjgwNcU",1.50,"patate dolci, pangrattato",TYPE.ANTIPASTI);
        Menu bevanda1=new Menu("coca cola","https://th.bing.com/th/id/OIP.8qV2gQfYfyYsN5LvIfNnLwHaFj?rs=1&pid=ImgDetMain",2.50,"bevanta analcolica",TYPE.BEVANDE);
        Menu bevanda2= new Menu("birra","https://wallpapercave.com/wp/wp3087049.jpg",4.00,"bevanda alcolica",TYPE.BEVANDE);
        Menu bevanda3=new Menu("acqua","https://th.bing.com/th/id/R.427a1740aa5f2534aa0336e733ea11fa?rik=hyvns%2fy%2bR0AHxA&pid=ImgRaw&r=0&sres=1&sresct=1",1.50,"ok, non lo so",TYPE.BEVANDE);
        Menu bevanda4=new Menu("fanta","https://th.bing.com/th/id/OIP.0g8thkPMcAfVQgOVptSrBQHaEo?rs=1&pid=ImgDetMain",2.50,"bevanda analcolica",TYPE.BEVANDE);
        Menu bevanda5=new Menu("estathe","https://assets.website-files.com/57741c10c8d072ad1d61520a/5cd93f8dc4df33300705f06a_Immagine2.jpg",2.50,"bevanda analcolica",TYPE.BEVANDE);
        menuDAO.save(pizza1);
        menuDAO.save(pizza2);
        menuDAO.save(pizza3);
        menuDAO.save(pizza4);
        menuDAO.save(pizza5);
        menuDAO.save(pizza6);
        menuDAO.save(pizza7);
        menuDAO.save(pizza8);
        menuDAO.save(pizza9);
        menuDAO.save(pizza10);
        menuDAO.save(antipasto1);
        menuDAO.save(antipasto2);
        menuDAO.save(antipasto3);
        menuDAO.save(antipasto4);
        menuDAO.save(antipasto5);
        menuDAO.save(antipasto6);
        menuDAO.save(antipasto7);
        menuDAO.save(antipasto8);
        menuDAO.save(antipasto9);
        menuDAO.save(antipasto10);
        menuDAO.save(bevanda1);
        menuDAO.save(bevanda2);
        menuDAO.save(bevanda3);
        menuDAO.save(bevanda4);
        menuDAO.save(bevanda5);

    }
}
