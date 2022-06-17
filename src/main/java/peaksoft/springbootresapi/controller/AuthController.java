package peaksoft.springbootresapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import peaksoft.springbootresapi.dto.AuthResponse;
import peaksoft.springbootresapi.dto.RegisterRequest;
import peaksoft.springbootresapi.entity.User;
import peaksoft.springbootresapi.security.JwtProvider;
import peaksoft.springbootresapi.service.UserService;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider provider;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest request){
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        userService.saveUser(user);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody RegisterRequest request){
        User user = userService.findByLoginAndPassword(request.getEmail(),request.getPassword());
        String token = provider.generaToken(user.getEmail());
        return new AuthResponse(token);
    }
}
