package igl.projet.hotel.service;

import igl.projet.hotel.model.User;
import igl.projet.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    UserRepository userRepository;

    @Override
    public User editUser(Long userId, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            return null;
        }

        User existingUser = optionalUser.get();

        // Update only the fields that are allowed to be updated
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setAddress(updatedUser.getAddress());
        existingUser.setRoles(updatedUser.getRoles());

        User savedUser = userRepository.save(existingUser);
        return savedUser;
    }

    @Override
    public Optional<User> getUser(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Long deleteUser(Long id) {
        userRepository.deleteById(id);
        return id;
    }
}
