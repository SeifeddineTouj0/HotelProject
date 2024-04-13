package igl.projet.hotel.controller;

import igl.projet.hotel.model.Room;
import igl.projet.hotel.payload.request.RoomRequest;
import igl.projet.hotel.repository.ReservationRepo;
import igl.projet.hotel.repository.RoomRepository;
import igl.projet.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/room")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomService roomService;




    @PostMapping(path="/add" , consumes = {"multipart/form-data"})
    public ResponseEntity<Room> createRoom(@ModelAttribute RoomRequest roomRequest) throws IOException {
        Room room = roomService.createRoom(roomRequest);
        return ResponseEntity.ok().body(room);
    }

    @PutMapping("/edit")
    public String editRoom(@RequestBody Room room){
        if(room.getId()==null){
            return "cannot edit";
        }
        roomRepository.save(room);
        return("succufully edited a room");
    }

    @DeleteMapping("/delete")
    public  String deletedRoom(@RequestParam Long id){
        roomRepository.deleteById(id);
        return("succufully deleted a room");
    }

    @GetMapping("/show")
    public List<Room> getRooms(){
        List<Room> rooms=roomRepository.findAll();
        return rooms;
    }

    @GetMapping("/get")
    public Optional<Room> getRooms(@RequestParam Long id){
        return roomRepository.findById(id);
    }

    @GetMapping("/available")
    public List<Room> getAvailableReservations(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") String startDate, @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam String endDate){
        Date startDateFormat = null;
        Date endDateFormat = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            startDateFormat = dateFormat.parse(startDate);
            endDateFormat = dateFormat.parse(endDate);
        } catch (ParseException e) {
            // Handle parsing exception
            e.printStackTrace();
        }
        return roomRepository.findAvailableRooms( startDateFormat,  endDateFormat);
    }

}
