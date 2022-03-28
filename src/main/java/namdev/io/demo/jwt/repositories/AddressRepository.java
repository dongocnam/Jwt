package namdev.io.demo.jwt.repositories;

import namdev.io.demo.jwt.entities.Address;
import namdev.io.demo.jwt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    /**
     * Find user by user name
     * @return User
     */
    Optional<Address> findByname(String name);
    /**
     * Check exists an user bu user name
     * @param username
     * @return Boolean
     */
}
