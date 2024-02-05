package brunocapobiancocom.example.pizzeria.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name="pizze")
@Getter
@Setter
@ToString
public class Pizze
{
    @Id
    @GeneratedValue
    private UUID idPizza;
    private String tipo;
    private double prezzo;
}
