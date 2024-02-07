package brunocapobiancocom.example.pizzeria.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "menu")
@Getter
@Setter
@ToString
public class Menu
{
    @Id
    @GeneratedValue
    private UUID idMenu;
    private String descrizione;
    private String image;
    private double prezzo;
    @Enumerated(EnumType.STRING)
    private TYPE type;
}

