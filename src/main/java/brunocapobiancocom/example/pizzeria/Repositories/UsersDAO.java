package brunocapobiancocom.example.pizzeria.Repositories;

import brunocapobiancocom.example.pizzeria.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface UsersDAO extends JpaRepository<Users, UUID>
{
    Optional<Users> findByEmail(String email);
}
