package brunocapobiancocom.example.pizzeria.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "menu")
@Getter
@Setter
@ToString
public class Menu
{
    @Id
    @GeneratedValue
    private String idMenu;
    @OneToOne
    @JoinColumn(name = "idPizza",nullable = false)
    private Pizze pizza;
    @OneToOne
    @JoinColumn(name="idAntipasti",nullable = false)
    private Antipasti antipasti;
}
