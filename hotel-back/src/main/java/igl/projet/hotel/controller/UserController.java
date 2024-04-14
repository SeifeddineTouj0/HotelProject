package igl.projet.hotel.controller;

import igl.projet.hotel.model.Reservation;
import igl.projet.hotel.model.User;
import igl.projet.hotel.repository.ReservationRepo;
import igl.projet.hotel.repository.UserRepository;
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
    UserRepository userRepository;

    @Autowired
    ReservationRepo reservationRepo;

    @PutMapping(path="/edit/{userId}")
    public ResponseEntity<User> editUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User existingUser = optionalUser.get();

        // Update only the fields that are allowed to be updated
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setAddress(updatedUser.getAddress());
        existingUser.setRoles(updatedUser.getRoles());
        // Add other fields that can be updated as needed

        /* If the password field in the updatedUser is not null or empty, update it
        String newPassword = updatedUser.getPassword();
        if (newPassword != null && !newPassword.isEmpty()) {
            // Encrypt or hash the password before saving
            existingUser.setPassword(passwordEncoder.encode(newPassword));
        }*/

        User savedUser = userRepository.save(existingUser);
        return ResponseEntity.ok().body(savedUser);
    }

    @GetMapping("/get/{userId}")
    Optional<User> getUser(@PathVariable Long userId){
        return userRepository.findById(userId);
    }

    @GetMapping("/show")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deletedRoom(@PathVariable Long id){
        userRepository.deleteById(id);
        return ResponseEntity.ok().body(id);
    }

}
