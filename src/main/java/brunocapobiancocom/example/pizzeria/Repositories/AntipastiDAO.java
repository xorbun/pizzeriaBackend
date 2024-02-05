package brunocapobiancocom.example.pizzeria.Repositories;

import brunocapobiancocom.example.pizzeria.Entities.Antipasti;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AntipastiDAO extends JpaRepository<Antipasti, UUID>
{
}
