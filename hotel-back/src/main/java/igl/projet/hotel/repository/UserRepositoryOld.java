package igl.projet.hotel.repository;

import igl.projet.hotel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryOld extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
