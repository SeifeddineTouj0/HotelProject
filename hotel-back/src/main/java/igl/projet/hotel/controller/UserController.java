package igl.projet.hotel.controller;

import igl.projet.hotel.model.Reservation;
import igl.projet.hotel.model.User;
import igl.projet.hotel.repository.ReservationRepo;
import igl.projet.hotel.repository.UserRepository;
import igl.projet.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ReservationRepo reservationRepo;

    @PutMapping(path="/edit/{userId}")
    public ResponseEntity<User> editUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        User savedUser = userService.editUser(userId,updatedUser);
        return ResponseEntity.ok().body(savedUser);
    }

    @GetMapping("/get/{userId}")
    Optional<User> getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }

    @GetMapping("/show")
    List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deletedUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().body(id);
    }

}
