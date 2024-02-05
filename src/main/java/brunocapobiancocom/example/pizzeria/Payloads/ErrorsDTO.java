package brunocapobiancocom.example.pizzeria.Payloads;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ErrorsDTO(String message, LocalDateTime timeStamp) {
}
