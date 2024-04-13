package igl.projet.hotel.repository;

import igl.projet.hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    @Query("SELECT r FROM Room r WHERE r NOT IN (SELECT res.room FROM Reservation res WHERE res.startDate <= :endDate AND res.endDate >= :startDate)")
    List<Room> findAvailableRooms(Date startDate, Date endDate);
}
