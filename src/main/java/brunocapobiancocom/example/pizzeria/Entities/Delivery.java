package brunocapobiancocom.example.pizzeria.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "delivery")
@Getter
@Setter
@ToString
public class Delivery
{
    @Id
    @GeneratedValue
    private UUID idDelivery;
    @ManyToOne
    @JoinColumn(name = "idUser",nullable = false)
    private Users user;
    @ManyToOne
    @JoinColumn(name="idMenu",nullable = false)
    private Menu menu;
    private int quantità;
    private double orario;
}