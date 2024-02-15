package brunocapobiancocom.example.pizzeria.Repositories;

import brunocapobiancocom.example.pizzeria.Entities.Menu;
import brunocapobiancocom.example.pizzeria.Entities.TYPE;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MenuDAO extends JpaRepository<Menu, UUID>
{
   @Query("SELECT m FROM Menu m WHERE m.type=:type")
   Page<Menu> findByType(Pageable pageable, @Param("type") TYPE type );
   Optional<Menu> findByDescrizione(String descrizione);
}
