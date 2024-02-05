package brunocapobiancocom.example.pizzeria.Payloads;

import java.time.LocalDate;
import java.util.UUID;

public record PrenotazioneDTO(UUID idUser, LocalDate data,double orario) {
}
