package no.oslomet.loginmicroservice.controller;

import no.oslomet.loginmicroservice.model.LoginUser;
import no.oslomet.loginmicroservice.repository.UserRepository;
import no.oslomet.loginmicroservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin
public class UserController {


    private UserRepository userRepository;

    private LoginService loginService;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserController(UserRepository userRepository, LoginService loginService) {
        this.userRepository = userRepository;
        this.loginService = loginService;
    }

    @PostMapping(value = "/login")
    @CrossOrigin
    public LoginUser login(Principal principal) {
        //LoginUser is already authenticated at this point.
        String email = principal.getName();
        System.out.println("Email: " + email);
        System.out.println("user to return: " + userRepository.findUserByEmail(email).get());
        return userRepository.findUserByEmail(email).get();
        //Dummy method to check if username and password is correct.
    }


    @PostMapping("/signup")
    public LoginUser register(@RequestBody LoginUser user) {
        String hashPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        user.setRoles("USER");
        loginService.save(user);
        return user;
    }

}
