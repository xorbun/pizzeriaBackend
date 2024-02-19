package brunocapobiancocom.example.pizzeria.Services;

import brunocapobiancocom.example.pizzeria.Entities.Menu;
import brunocapobiancocom.example.pizzeria.Entities.TYPE;
import brunocapobiancocom.example.pizzeria.Exceptions.NotFoundException;
import brunocapobiancocom.example.pizzeria.Payloads.MenuDTO;
import brunocapobiancocom.example.pizzeria.Repositories.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MenuService
{
    @Autowired
    private MenuDAO menuDAO;

    public Page<Menu> getMenu(int page,int size,String orderBy)
    {
        if(size>=100)size=100;
        Pageable pageable= PageRequest.of(page,size, Sort.by(orderBy));
        return menuDAO.findAll(pageable);
    }
    public Menu findById(UUID idMenu)
    {
        return menuDAO.findById(idMenu).orElseThrow(()->new NotFoundException(idMenu));
    }
    public Menu save(MenuDTO body)
    {
        Menu newMenu=new Menu();
        newMenu.setImage(body.image());
        newMenu.setDescrizione(body.descrizione());
        newMenu.setType(TYPE.valueOf(body.type()));
        newMenu.setIngredienti(body.ingredienti());
        newMenu.setPrezzo(body.prezzo());
        return menuDAO.save(newMenu);
    }
    public Menu findByIdAndUpdate(UUID idMenu,MenuDTO body)
    {
        Menu found=this.findById(idMenu);
        found.setImage(body.image());
        found.setPrezzo(body.prezzo());
        return menuDAO.save(found);
    }
    public void findByIdAndDelete(UUID idMenu)
    {
        Menu found=this.findById(idMenu);
        menuDAO.delete(found);
    }
    public Page<Menu> findByType(int page,int size,String orderBy,String type)
    {
        if(size>=100)size=100;
        Pageable pageable=PageRequest.of(page,size,Sort.by(orderBy));
        return menuDAO.findByType(pageable,TYPE.valueOf(type));
    }
    public Menu findByName(String nome)
    {
        return menuDAO.findByDescrizione(nome).orElseThrow(()->new NotFoundException(nome));
    }

}
