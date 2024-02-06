package brunocapobiancocom.example.pizzeria.Controllers;

import brunocapobiancocom.example.pizzeria.Entities.Antipasti;
import brunocapobiancocom.example.pizzeria.Payloads.AntipastiDTO;
import brunocapobiancocom.example.pizzeria.Repositories.AntipastiDAO;
import brunocapobiancocom.example.pizzeria.Services.AntipastiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/antipasti")
public class AntipastiController
{
    @Autowired
    private AntipastiService antipastiService;
    @GetMapping
    public Page<Antipasti> getAntipasti(@RequestParam(defaultValue = "0")int page,
                                        @RequestParam(defaultValue = "10")int size,
                                        @RequestParam(defaultValue = "tipo")String orderBy)
    {
        return antipastiService.getAntipasti(page,size,orderBy);
    }
    @GetMapping("/{idAntipasti}")
    public Antipasti getAntipastiById(@PathVariable UUID idAntipasti)
    {
        return antipastiService.findById(idAntipasti);
    }
    @PostMapping
    public Antipasti addAntipasto(@RequestBody AntipastiDTO newAntipastiPayload)
    {
        return antipastiService.save(newAntipastiPayload);
    }
    @PutMapping("/{idAntipasti}")
    public Antipasti findByIdAndUpdate(@PathVariable UUID idAntipasti,@RequestBody AntipastiDTO newAntipastiPayload)
    {
        return antipastiService.findByIdAndUpdate(idAntipasti,newAntipastiPayload);
    }
    @DeleteMapping("/{idAntipasti}")
    public void findByIdAndDelete(@PathVariable UUID idAntipasti)
    {
        antipastiService.findByIdAndDelete(idAntipasti);
    }
}
