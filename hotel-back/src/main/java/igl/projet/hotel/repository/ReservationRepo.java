package igl.projet.hotel.repository;

import igl.projet.hotel.model.Reservation;
import igl.projet.hotel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepo  extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(Optional<User> user);
}
