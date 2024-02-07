package brunocapobiancocom.example.pizzeria.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "menu")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class Menu
{
    @Id
    @GeneratedValue
    private UUID idMenu;
    @NonNull
    private String descrizione;
    @NonNull
    private String image;
    @NonNull
    private double prezzo;
    @NonNull
    @Enumerated(EnumType.STRING)
    private TYPE type;
}

