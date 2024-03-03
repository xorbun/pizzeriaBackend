package brunocapobiancocom.example.pizzeria.Entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;
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
    private String ingredienti;
    @NonNull
    @Enumerated(EnumType.STRING)
    private TYPE type;

    private String priceId;

    public Menu(@NonNull String descrizione, @NonNull String image, @NonNull double prezzo, @NonNull String ingredienti, @NonNull TYPE type, String priceId) {
        this.descrizione = descrizione;
        this.image = image;
        this.prezzo = prezzo;
        this.ingredienti = ingredienti;
        this.type = type;
        this.priceId = priceId;
    }
}

