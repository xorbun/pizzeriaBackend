package brunocapobiancocom.example.pizzeria.Services;

import brunocapobiancocom.example.pizzeria.Entities.Delivery;
import brunocapobiancocom.example.pizzeria.Entities.Menu;
import brunocapobiancocom.example.pizzeria.Entities.STATO;
import brunocapobiancocom.example.pizzeria.Entities.Users;
import brunocapobiancocom.example.pizzeria.Exceptions.NotFoundException;
import brunocapobiancocom.example.pizzeria.Payloads.DeliveryDTO;
import brunocapobiancocom.example.pizzeria.Repositories.DeliveryDAO;
import brunocapobiancocom.example.pizzeria.Repositories.MenuDAO;
import brunocapobiancocom.example.pizzeria.Repositories.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DeliveryService
{
    @Autowired
    private DeliveryDAO deliveryDAO;
    @Autowired
    private MenuDAO menuDAO;
    @Autowired
    private UsersDAO usersDAO;

    public Page<Delivery> getDelivery(int page,int size,String orderBy)
    {
        if(size>=100)size=100;
        Pageable pageable= PageRequest.of(page,size, Sort.by(orderBy));
        return deliveryDAO.findAll(pageable);
    }
    public Delivery findDeliveryById(UUID idDelivery)
    {
        return deliveryDAO.findById(idDelivery).orElseThrow(()->new NotFoundException(idDelivery));
    }
    public Delivery addDelivery(UUID idUser, UUID idMenu, DeliveryDTO body)
    {
        Delivery newdelivery=new Delivery();
        newdelivery.setUser(usersDAO.findById(idUser).orElseThrow(()->new NotFoundException(idUser)));
        newdelivery.setMenu(menuDAO.findById(idMenu).orElseThrow(()->new NotFoundException(idMenu)));
        newdelivery.setQuantita(body.quantita());
        newdelivery.setTotale(body.quantita()*newdelivery.getMenu().getPrezzo());
        LocalTime oraAttuale=LocalTime.now();
        int ora=oraAttuale.getHour();
        int minuti=oraAttuale.getMinute();
        newdelivery.setOrario(LocalTime.of(ora,minuti));
        newdelivery.setDataDelivery(LocalDate.now());
        newdelivery.setStato(STATO.INVIATO);
        System.out.println("arrivi qui");
        return deliveryDAO.save(newdelivery);
    }
    public Delivery FindDeliveryByIdAndUpdate(UUID idDelivery,UUID idMenu,DeliveryDTO body)
    {
        Delivery found=this.findDeliveryById(idDelivery);
        found.setMenu(menuDAO.findById(idMenu).orElseThrow(()->new NotFoundException(idMenu)));
        found.setQuantita(body.quantita());
        found.setOrario(body.orario());
        return deliveryDAO.save(found);
    }
    public void findDeliveryByIdAndDelete(UUID idDelivery)
    {
        Delivery found=this.findDeliveryById(idDelivery);
        deliveryDAO.delete(found);
    }
    public Page<Delivery> findDeliveryByUser(int page,int size,String orderBy,UUID idUser)
    {
        if(size>=100)size=100;
        Pageable pageable=PageRequest.of(page,size,Sort.by(orderBy));
        return deliveryDAO.findByUserIdUserAndDataDelivery(pageable,idUser,LocalDate.now());
    }
    public Page<Delivery> countOrderByUser(int page,int size, String orderBy)
    {
        Pageable pageable=PageRequest.of(page,size,Sort.by(orderBy));
        return deliveryDAO.countOrderByUserIdUserAndFindByDataDelivery(pageable,LocalDate.now());
    }
    public List<Delivery> UpdateStato(UUID idUser)
    {
        List<Delivery> deliveryList=deliveryDAO.findByUserIdUserAndDataDelivery(idUser,LocalDate.now());
        for(Delivery found:deliveryList)
        {
            found.setStato(STATO.IN_CONSEGNA);
            deliveryDAO.save(found);
        }
        return deliveryList;
    }

}
