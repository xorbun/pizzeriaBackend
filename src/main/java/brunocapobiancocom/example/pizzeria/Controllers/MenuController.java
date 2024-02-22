package brunocapobiancocom.example.pizzeria.Controllers;

import brunocapobiancocom.example.pizzeria.Entities.Menu;
import brunocapobiancocom.example.pizzeria.Payloads.MenuDTO;
import brunocapobiancocom.example.pizzeria.Services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/menu")
public class MenuController
{
    @Autowired
    private MenuService menuService;

    @GetMapping
    public Page<Menu> getAllFoods(@RequestParam(defaultValue = "0")int page,
                                  @RequestParam(defaultValue = "40")int size,
                                  @RequestParam(defaultValue = "descrizione") String orderBy)
    {
        return menuService.getMenu(page,size,orderBy);
    }
    @GetMapping("/{idMenu}")
    public Menu getFoodById(@PathVariable UUID idMenu)
    {
       return menuService.findById(idMenu);
    }
    @PostMapping

    public Menu addFood(@RequestBody MenuDTO newMenuPayload)
    {
        return menuService.save(newMenuPayload);
    }


    @PostMapping("/upload")
    public String uploadImage(@RequestParam("image")MultipartFile file, @PathVariable UUID idMenu) throws IOException
    {
        return menuService.uploadPicture(file,idMenu);
    }


    @PutMapping("/{idMenu}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Menu findByIdAndUpdate(@PathVariable UUID idMenu,@RequestBody MenuDTO modifyMenuPayload)
    {
        return menuService.findByIdAndUpdate(idMenu,modifyMenuPayload);
    }
    @DeleteMapping("/{idMenu}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void findByIdAndDelete(@PathVariable UUID idMenu)
    {
        menuService.findByIdAndDelete(idMenu);
    }
    @GetMapping("/type")
    public Page<Menu> findByType(@RequestParam(defaultValue = "0")int page,
                                 @RequestParam(defaultValue = "10")int size,
                                 @RequestParam(defaultValue = "descrizione")String orderBy,
                                 @RequestParam String type)
    {

        return menuService.findByType(page,size,orderBy,type);
    }
    @GetMapping("/cerca")
    public Menu findByNome(@RequestParam String nome)
    {
        return menuService.findByName(nome);
    }
}
