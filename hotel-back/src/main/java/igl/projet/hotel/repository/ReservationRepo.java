package igl.projet.hotel.repository;

import igl.projet.hotel.model.Reservation;
import igl.projet.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ReservationRepo  extends JpaRepository<Reservation, Long> {

}
