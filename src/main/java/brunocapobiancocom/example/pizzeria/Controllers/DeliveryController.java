package brunocapobiancocom.example.pizzeria.Controllers;

import brunocapobiancocom.example.pizzeria.Entities.Delivery;
import brunocapobiancocom.example.pizzeria.Entities.Users;
import brunocapobiancocom.example.pizzeria.Payloads.DeliveryDTO;
import brunocapobiancocom.example.pizzeria.Services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/delivery")
public class DeliveryController
{
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping
    public Page<Delivery> getAllDelivery(@RequestParam(defaultValue = "0")int page,
                                         @RequestParam(defaultValue = "10")int size,
                                         @RequestParam(defaultValue = "orario")String orderBy)
    {
        return deliveryService.getDelivery(page,size,orderBy);
    }
    @GetMapping("/{idDelivery}")
    public Delivery findDeliveryById(@PathVariable UUID idDelivery)
    {
        return deliveryService.findDeliveryById(idDelivery);
    }
    @PostMapping
    public Delivery addDelivery(@AuthenticationPrincipal Users currentUser, @RequestParam UUID idMenu, @RequestBody DeliveryDTO newDeliveryPayload)
    {
        return deliveryService.addDelivery(currentUser.getIdUser(),idMenu,newDeliveryPayload);
    }
    @PutMapping("/{idDelivery}")
    public Delivery findDeliveryByIdAndUpdate(@PathVariable UUID idDelivery,@RequestParam UUID idMenu,@RequestBody DeliveryDTO modifyDeliveryPayload)
    {
        return deliveryService.FindDeliveryByIdAndUpdate(idDelivery,idMenu,modifyDeliveryPayload);
    }
    @DeleteMapping("/{idDelivery}")
    public void findDeliveryByIdAndDelete(@PathVariable UUID idDelivery)
    {
        deliveryService.findDeliveryByIdAndDelete(idDelivery);
    }
    @GetMapping("/id")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Page<Delivery> findDeliveryByUser(@RequestParam (defaultValue = "0")int page,
                                             @RequestParam(defaultValue = "10")int size,
                                             @RequestParam(defaultValue = "orario")String orderBy,
                                             @RequestParam UUID idUser)
    {
        return deliveryService.findDeliveryByUser(page,size,orderBy,idUser);
    }
    @GetMapping("/me")
    public Page<Delivery> findDeliveryByCurrentUser(@RequestParam (defaultValue = "0")int page,
                                                  @RequestParam(defaultValue = "10")int size,
                                                  @RequestParam(defaultValue = "orario")String orderBy,
                                                  @AuthenticationPrincipal Users currentUser)
    {
        return deliveryService.findDeliveryByUser(page,size,orderBy,currentUser.getIdUser());
    }
}
