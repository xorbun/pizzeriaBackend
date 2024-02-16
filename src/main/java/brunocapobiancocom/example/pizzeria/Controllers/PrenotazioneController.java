package brunocapobiancocom.example.pizzeria.Controllers;

import brunocapobiancocom.example.pizzeria.Entities.Prenotazione;
import brunocapobiancocom.example.pizzeria.Entities.Users;
import brunocapobiancocom.example.pizzeria.Payloads.PrenotazioneDTO;
import brunocapobiancocom.example.pizzeria.Services.PrenotazioneService;
import brunocapobiancocom.example.pizzeria.Services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController
{
    @Autowired
    private PrenotazioneService prenotazioneService;

    @GetMapping
    public Page<Prenotazione> getPrenotazioni(@RequestParam(defaultValue = "0")int page,
                                              @RequestParam(defaultValue = "10")int size,
                                              @RequestParam(defaultValue = "data")String orderBy)
    {
        return prenotazioneService.getPrenotazioni(page,size,orderBy);
    }
    @GetMapping("/{idPrenotazioni}")
    public Prenotazione getPrenotazioneById(@PathVariable UUID idPrenotazioni)
    {
        return prenotazioneService.findById(idPrenotazioni);
    }
    @PostMapping
    public Prenotazione addPrenotazione(@AuthenticationPrincipal Users currentUser, @RequestBody PrenotazioneDTO newPrenotazionePayload)
    {
        return prenotazioneService.addPrenotazione(currentUser.getIdUser(),newPrenotazionePayload);
    }
    @PutMapping("/{idPrenotazioni}")
    public Prenotazione findPrenotazioneByIdAndUpdate(@PathVariable UUID idPrenotazioni,@RequestBody PrenotazioneDTO modifyPrenotazionePayload)
    {
        return prenotazioneService.findByIdAndUpdate(idPrenotazioni,modifyPrenotazionePayload);
    }
    @DeleteMapping("/{idPrenotazioni}")
    public void findPrenotazioneByIdAndDelete(@PathVariable UUID idPrenotazioni)
    {
        prenotazioneService.findByIdAndDelete(idPrenotazioni);
    }
    @GetMapping("/me")
    public List<Prenotazione> findByUser(@AuthenticationPrincipal Users user)
    {
        return prenotazioneService.findByUser(user.getIdUser());
    }
}
