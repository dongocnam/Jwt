package namdev.io.demo.jwt.repositories;

import namdev.io.demo.jwt.common.ERole;
import namdev.io.demo.jwt.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * Find role by name
     * @param name
     * @return Role
     */
    Optional<Role> findByName(ERole name);
}
