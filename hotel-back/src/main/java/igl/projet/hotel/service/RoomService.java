package igl.projet.hotel.service;

import igl.projet.hotel.model.Room;
import igl.projet.hotel.payload.request.RoomRequest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface RoomService {
    Room createRoom(RoomRequest roomRequest) throws IOException;
    Room editRoom(RoomRequest roomRequest);

    public void deleteRoom(Long id);
    public List<Room> getAllRooms();

    Optional<Room> getRoom(Long id);

    List<Room> getAvailableReservations(String startDate, String endDate);
}
