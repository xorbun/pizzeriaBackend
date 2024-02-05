package brunocapobiancocom.example.pizzeria.Payloads;

import brunocapobiancocom.example.pizzeria.Entities.TIPO;

public record UsersDTO(String nome, String cognome, String nickname, String email, String password, TIPO tipo) {
}
