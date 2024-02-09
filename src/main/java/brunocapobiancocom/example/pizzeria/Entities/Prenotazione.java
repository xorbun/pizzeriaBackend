package brunocapobiancocom.example.pizzeria.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "prenotazioni")
@Getter
@Setter
@ToString
public class Prenotazione
{
    @Id
    @GeneratedValue
    private UUID prenotazione;
    @ManyToOne
    @JoinColumn(name = "idUser",nullable = false)
    private Users user;
    private LocalDate data;
    private LocalTime orario;
    private double numeroPersone;
}
