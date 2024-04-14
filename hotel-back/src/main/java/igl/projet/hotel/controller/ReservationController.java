package igl.projet.hotel.controller;

import igl.projet.hotel.model.Reservation;
import igl.projet.hotel.model.User;
import igl.projet.hotel.repository.UserRepository;
import igl.projet.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class ReservationController {


    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) throws Exception {
        reservationService.addReservation(reservation);
        return ResponseEntity.ok().body(reservation);
    }

    @GetMapping("/show")
    public List<Reservation> getReservations(){
        return reservationService.getReservations();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deletedReservation(@PathVariable Long id){
        reservationService.deleteReservation(id);
        return ResponseEntity.ok().body(id);
    }
    @GetMapping("/user/{userId}")
    public List<Reservation> getReservationsByUser(@PathVariable Long userId){
        Optional<User> user= userRepository.findById(userId);
        return reservationService.getReservationsByUser(user);
    }


}
