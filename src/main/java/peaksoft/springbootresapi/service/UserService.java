package peaksoft.springbootresapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import peaksoft.springbootresapi.entity.Role;
import peaksoft.springbootresapi.entity.User;
import peaksoft.springbootresapi.repository.RoleRepository;
import peaksoft.springbootresapi.repository.UserRepository;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        Role userRole = roleRepository.findByRoleName("ROLE_ADMIN");
        user.setRole(userRole);
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByLoginAndPassword(String email, String password) {
        User user = findByEmail(email);
        if (user != null) {
            return user;
        }
        return null;
    }

}
