package igl.projet.hotel.repository;

import igl.projet.hotel.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo  extends JpaRepository<Reservation, Long> {
}
