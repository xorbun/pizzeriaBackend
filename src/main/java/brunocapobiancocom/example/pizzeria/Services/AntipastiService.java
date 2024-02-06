package brunocapobiancocom.example.pizzeria.Services;

import brunocapobiancocom.example.pizzeria.Entities.Antipasti;
import brunocapobiancocom.example.pizzeria.Exceptions.NotFoundException;
import brunocapobiancocom.example.pizzeria.Payloads.AntipastiDTO;
import brunocapobiancocom.example.pizzeria.Repositories.AntipastiDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AntipastiService
{
    @Autowired
    private AntipastiDAO antipastiDAO;

    public Page<Antipasti> getAntipasti(int page,int size, String orderBy)
    {
        if (size>=100)size=100;
        Pageable pageable= PageRequest.of(page,size, Sort.by(orderBy));
        return antipastiDAO.findAll(pageable);
    }
    public Antipasti findById(UUID idAntipasti)
    {
        return antipastiDAO.findById(idAntipasti).orElseThrow(()->new NotFoundException(idAntipasti));
    }
    public Antipasti save(AntipastiDTO body)
    {
        Antipasti newAntipasti=new Antipasti();
        newAntipasti.setTipo(body.tipo());
        newAntipasti.setImage(body.image());
        newAntipasti.setPrezzo(body.prezzo());
        return antipastiDAO.save(newAntipasti);
    }
    public Antipasti findByIdAndUpdate(UUID idAntipasti, AntipastiDTO body)
    {
        Antipasti found=this.findById(idAntipasti);
        found.setImage(body.image());
        found.setPrezzo(body.prezzo());
        return antipastiDAO.save(found);
    }
    public void findByIdAndDelete(UUID idAntipasti)
    {
        Antipasti found=this.findById(idAntipasti);
        antipastiDAO.delete(found);
    }
}
