package igl.projet.hotel.service;

import igl.projet.hotel.model.Reservation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ReservationService {

    public void addReservation( Reservation reservation);


    public List<Reservation> getReservations();
}
