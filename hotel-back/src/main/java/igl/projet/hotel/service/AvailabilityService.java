package igl.projet.hotel.service;

import igl.projet.hotel.model.Availability;
import igl.projet.hotel.model.Room;
import igl.projet.hotel.payload.request.RoomRequest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface AvailabilityService {
    Availability createAvailability(Availability availability);
    Availability editAvailability(Availability availability);

    public void deleteAvailability(Long id);

}
