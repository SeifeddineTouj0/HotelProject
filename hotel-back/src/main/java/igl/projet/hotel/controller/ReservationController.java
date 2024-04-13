package igl.projet.hotel.controller;

import igl.projet.hotel.model.Reservation;
import igl.projet.hotel.model.Room;
import igl.projet.hotel.repository.ReservationRepo;
import igl.projet.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class ReservationController {


    @Autowired
    private ReservationService reservationService;

    @PostMapping("/add")
    public void addReservation(@RequestBody Reservation reservation){
        reservationService.addReservation(reservation);
        ResponseEntity.ok().body(reservation);
    }

    @GetMapping("/show")
    public List<Reservation> getReservations(){
        return reservationService.getReservations();
    }


}
