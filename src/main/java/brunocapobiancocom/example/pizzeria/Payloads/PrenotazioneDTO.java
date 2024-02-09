package brunocapobiancocom.example.pizzeria.Payloads;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public record PrenotazioneDTO( LocalDate data, LocalTime orario, int numeroPersone) {
}
