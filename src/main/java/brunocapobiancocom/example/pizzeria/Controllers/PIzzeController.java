package brunocapobiancocom.example.pizzeria.Controllers;

import brunocapobiancocom.example.pizzeria.Entities.Pizze;
import brunocapobiancocom.example.pizzeria.Payloads.PizzeDTO;
import brunocapobiancocom.example.pizzeria.Services.PizzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pizze")
public class PIzzeController
{
    @Autowired
    private PizzeService pizzeService;

    @GetMapping
    public Page<Pizze> getPizze(@RequestParam(defaultValue = "0")int page,
                                @RequestParam(defaultValue = "10")int size,
                                @RequestParam(defaultValue = "tipo")String orderBy)
    {
        return pizzeService.getPizza(page,size,orderBy);
    }
    @GetMapping("/{idPizza}")
    public Pizze getPizzaById(UUID idPizza)
    {
        return pizzeService.findById(idPizza);
    }
    @PostMapping
    public Pizze addPizza(@RequestBody PizzeDTO newPizzaPayload)
    {
        return pizzeService.save(newPizzaPayload);
    }
    @PutMapping("/{idPizza}")
    public Pizze changePizza(@PathVariable UUID idPizza,@RequestBody PizzeDTO newPizzaPayload)
    {
        return pizzeService.findByIdAndUpdate(idPizza,newPizzaPayload);
    }
    @DeleteMapping("/{idPizza}")
    public void deletePizza(UUID idPizza)
    {
        pizzeService.findByIdAndDelete(idPizza);
    }



}
