package brunocapobiancocom.example.pizzeria.Payloads;

import brunocapobiancocom.example.pizzeria.Entities.ROLE;

public record UsersDTO(String nome, String cognome, String nickname,String address, String email, String password, ROLE tipo) {
}
