package brunocapobiancocom.example.pizzeria.Services;

import brunocapobiancocom.example.pizzeria.Entities.Pizze;
import brunocapobiancocom.example.pizzeria.Exceptions.NotFoundException;
import brunocapobiancocom.example.pizzeria.Payloads.PizzeDTO;
import brunocapobiancocom.example.pizzeria.Repositories.PizzeDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PizzeService
{
    private PizzeDAO pizzeDAO;

    public Page<Pizze> getPizza(int page,int size,String orderBy)
    {
        if(size>=100)size=100;
        Pageable pageable= PageRequest.of(page,size, Sort.by(orderBy));
        return pizzeDAO.findAll(pageable);
    }
    public Pizze findById(UUID idPizza)
    {
        return pizzeDAO.findById(idPizza).orElseThrow(()->new NotFoundException(idPizza));
    }
    public Pizze save(PizzeDTO body)
    {
        Pizze newPizza= new Pizze();
        newPizza.setTipo(body.tipo());
        newPizza.setImage(body.image());
        newPizza.setPrezzo(body.prezzo());
        return pizzeDAO.save(newPizza);
    }
    public Pizze findByIdAndUpdate(UUID idPizza, PizzeDTO body)
    {
        Pizze found=this.findById(idPizza);
        found.setImage(body.image());
        found.setPrezzo(body.prezzo());
        return pizzeDAO.save(found);
    }
    public void findByIdAndDelete(UUID idPizza)
    {
        Pizze found=this.findById(idPizza);
        pizzeDAO.delete(found);
    }
}
