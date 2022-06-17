package peaksoft.springbootresapi.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import peaksoft.springbootresapi.entity.CustomUserDetails;
import peaksoft.springbootresapi.entity.User;
import peaksoft.springbootresapi.service.UserService;


@Component

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        return CustomUserDetails.fromEntityToCustomUserDetails(user);
    }
}
