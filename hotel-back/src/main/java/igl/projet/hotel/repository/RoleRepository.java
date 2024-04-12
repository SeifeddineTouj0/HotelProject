package igl.projet.hotel.repository;

import java.util.Optional;

import igl.projet.hotel.model.ERole;
import igl.projet.hotel.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);

}
