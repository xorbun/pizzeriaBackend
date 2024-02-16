package brunocapobiancocom.example.pizzeria.Services;

import brunocapobiancocom.example.pizzeria.Entities.Prenotazione;
import brunocapobiancocom.example.pizzeria.Exceptions.NotFoundException;
import brunocapobiancocom.example.pizzeria.Payloads.PrenotazioneDTO;
import brunocapobiancocom.example.pizzeria.Repositories.PrenotazioneDAO;
import brunocapobiancocom.example.pizzeria.Repositories.UsersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PrenotazioneService
{
    @Autowired
    private PrenotazioneDAO prenotazioneDAO;
    @Autowired
    private UsersDAO usersDAO;

    public Page<Prenotazione> getPrenotazioni(int page,int size,String orderBy)
    {
        if(size>=100)size=100;
        Pageable pageable= PageRequest.of(page,size, Sort.by(orderBy));
        return prenotazioneDAO.findAll(pageable);
    }
    public Prenotazione findById(UUID idPrenotazione)
    {
        return prenotazioneDAO.findById(idPrenotazione).orElseThrow(()->new NotFoundException(idPrenotazione));
    }
    public Prenotazione addPrenotazione(UUID idUser, PrenotazioneDTO body)
    {
        Prenotazione newPrenotazione= new Prenotazione();
        newPrenotazione.setUser(usersDAO.findById(idUser).orElseThrow(()->new NotFoundException(idUser)));
        newPrenotazione.setData(body.data());
        newPrenotazione.setOrario(body.orario());
        newPrenotazione.setNumeroPersone(body.numeroPersone());
        return prenotazioneDAO.save(newPrenotazione);
    }
    public Prenotazione findByIdAndUpdate(UUID idPrenotazione,PrenotazioneDTO body)
    {
        Prenotazione found=this.findById(idPrenotazione);
        found.setData(body.data());
        found.setOrario(body.orario());
        found.setNumeroPersone(body.numeroPersone());
        return prenotazioneDAO.save(found);
    }
    public void findByIdAndDelete(UUID idPrenotazione)
    {
        Prenotazione found=this.findById(idPrenotazione);
        prenotazioneDAO.delete(found);
    }
    public List<Prenotazione> findByUser(UUID idUser)
    {
        return prenotazioneDAO.findByUserId(idUser);
    }
}
