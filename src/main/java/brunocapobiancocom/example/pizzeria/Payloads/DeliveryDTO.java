package brunocapobiancocom.example.pizzeria.Payloads;

import java.util.UUID;

public record DeliveryDTO(UUID idUser,UUID idMenu,int quantità,double orario) {
}
