package brunocapobiancocom.example.pizzeria.Payloads;

import brunocapobiancocom.example.pizzeria.Entities.STATO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public record DeliveryDTO(List<UUID> idMenu) {
}
