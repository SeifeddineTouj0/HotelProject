package igl.projet.hotel.service;

import igl.projet.hotel.model.Room;
import igl.projet.hotel.payload.request.RoomRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;

public interface RoomService {
    Room createRoom(RoomRequest roomRequest) throws IOException;
}
