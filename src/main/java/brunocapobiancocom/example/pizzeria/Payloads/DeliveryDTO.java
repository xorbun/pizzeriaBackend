package brunocapobiancocom.example.pizzeria.Payloads;

import java.time.LocalTime;
import java.util.UUID;

public record DeliveryDTO(int quantita, LocalTime orario) {
}
