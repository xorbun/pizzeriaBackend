package brunocapobiancocom.example.pizzeria.Payloads;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record DeliveryDTO(int quantita,double totale, LocalTime orario, LocalDate dataDelivery) {
}
