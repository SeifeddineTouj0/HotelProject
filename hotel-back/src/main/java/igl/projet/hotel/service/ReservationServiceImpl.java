package igl.projet.hotel.service;

import igl.projet.hotel.model.Reservation;
import igl.projet.hotel.repository.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepo reservationRepo;

    @Override
    public void addReservation(@RequestBody Reservation reservation){
        reservationRepo.save(reservation);
    }

    @Override
    public List<Reservation> getReservations(){
        return reservationRepo.findAll();
    }


}
