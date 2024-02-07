package brunocapobiancocom.example.pizzeria.Payloads;

import brunocapobiancocom.example.pizzeria.Entities.TYPE;

import java.util.UUID;

public record MenuDTO(String descrizione, String image, double prezzo, String type) {
}
