package namdev.io.restapi.reppository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import namdev.io.restapi.model.User;



public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameContaining(String q);
} 