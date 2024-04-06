package igl.projet.hotel.controller;

import igl.projet.hotel.model.Room;
import igl.projet.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/room")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @PostMapping("/add")
    public String addRoom(@RequestBody Room room){
        roomRepository.save(room);
        return("succufully added a room");
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


}
