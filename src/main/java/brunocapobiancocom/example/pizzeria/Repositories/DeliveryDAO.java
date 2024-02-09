package brunocapobiancocom.example.pizzeria.Repositories;

import brunocapobiancocom.example.pizzeria.Entities.Delivery;
import brunocapobiancocom.example.pizzeria.Entities.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeliveryDAO extends JpaRepository<Delivery, UUID>
{
    Page<Delivery> findByUserIdUserAndDataDelivery(Pageable pageable, UUID idUser, LocalDate date);
}
