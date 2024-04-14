package igl.projet.hotel.controller;

import igl.projet.hotel.model.Room;
import igl.projet.hotel.payload.request.RoomRequest;
import igl.projet.hotel.repository.RoomRepository;
import igl.projet.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/room")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class RoomController {


    @Autowired
    private RoomService roomService;




    @PostMapping(path="/add" )
    public ResponseEntity<Room> createRoom(@RequestBody RoomRequest roomRequest) throws IOException {
        Room room = roomService.createRoom(roomRequest);
        return ResponseEntity.ok().body(room);
    }

    @PutMapping(path="/edit" , consumes = {"multipart/form-data"})
    public ResponseEntity<Room> editRoom(@ModelAttribute RoomRequest roomRequest){
        Room room = roomService.editRoom(roomRequest);
        return ResponseEntity.ok().body(room);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Long> deletedRoom(@RequestParam Long id){
        roomService.deleteRoom(id);
        return ResponseEntity.ok().body(id);
    }

    @GetMapping("/show")
    public List<Room> getAllRooms(){
       return roomService.getAllRooms();
    }

    @GetMapping("/get")
    public Optional<Room> getRoom(@RequestParam Long id){
        return roomService.getRoom(id);
    }

    @GetMapping("/available")
    public List<Room> getAvailableReservations(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") String startDate, @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam String endDate){
       return roomService.getAvailableReservations(startDate,endDate);
    }

}
