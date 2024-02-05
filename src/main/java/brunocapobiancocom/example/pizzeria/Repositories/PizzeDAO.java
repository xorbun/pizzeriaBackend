package brunocapobiancocom.example.pizzeria.Repositories;

import brunocapobiancocom.example.pizzeria.Entities.Pizze;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PizzeDAO extends JpaRepository<Pizze, UUID>
{
}
