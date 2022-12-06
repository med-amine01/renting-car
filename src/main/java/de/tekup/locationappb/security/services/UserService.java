package de.tekup.locationappb.security.services;

import de.tekup.locationappb.security.entites.Role;
import de.tekup.locationappb.security.entites.User;
import de.tekup.locationappb.security.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public void registerUser(User user){
        user.setRole(Role.ROLE_USER);
        userRepository.save(user);
    }
}
