package igl.projet.hotel.service;

import igl.projet.hotel.model.Reservation;
import igl.projet.hotel.model.User;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    public void addReservation( Reservation reservation);


    public List<Reservation> getReservations();

    void deleteReservation(Long id);
    List<Reservation> getReservationsByUser(Optional<User> user);
}
