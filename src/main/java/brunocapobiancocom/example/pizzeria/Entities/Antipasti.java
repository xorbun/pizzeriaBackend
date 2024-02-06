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
@Table(name="antipasti")
@Getter
@Setter
@ToString
public class Antipasti
{
    @Id
    @GeneratedValue
    private UUID idAntipasti;
    private String tipo;
    private String image;
    private double prezzo;
}
