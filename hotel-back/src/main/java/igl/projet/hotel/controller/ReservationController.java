package igl.projet.hotel.controller;

import igl.projet.hotel.model.Reservation;
import igl.projet.hotel.model.Room;
import igl.projet.hotel.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepo reservationRepo;

    @PostMapping("/add")
    public void addReservation(@RequestBody Reservation reservation){
        reservationRepo.save(reservation);
    }

}
