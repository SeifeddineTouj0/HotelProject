package igl.projet.hotel.service;

import igl.projet.hotel.model.Reservation;
import igl.projet.hotel.model.User;
import igl.projet.hotel.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepo reservationRepo;

    @Override
    public void addReservation(@RequestBody Reservation reservation){
        System.out.println(reservation);
        reservationRepo.save(reservation);
    }

    public Reservation editReservation( Reservation reservation){
        return reservationRepo.save(reservation);
    }

    @Override
    public List<Reservation> getReservations(){
        return reservationRepo.findAll();
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepo.deleteById(id);
    }

    @Override
    public List<Reservation> getReservationsByUser(Optional<User> user){
        return reservationRepo.findByUser(user);
    }


}
