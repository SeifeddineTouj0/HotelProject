package igl.projet.hotel.service;

import igl.projet.hotel.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User editUser(Long userId, User updatedUser);
    Optional<User> getUser( Long userId);
    List<User> getAllUsers();
    public Long deleteUser( Long id);
}
