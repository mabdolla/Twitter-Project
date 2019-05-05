package no.oslomet.loginmicroservice;

import no.oslomet.loginmicroservice.model.LoginUser;
import no.oslomet.loginmicroservice.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@SpringBootApplication
public class LoginMicroserviceApplication {

    private static final Logger log = LoggerFactory.getLogger(LoginMicroserviceApplication.class);

    private final LoginService loginService;

    @Autowired
    public LoginMicroserviceApplication(LoginService loginService) {
        this.loginService = loginService;
    }


    public static void main(String[] args) {
        SpringApplication.run(LoginMicroserviceApplication.class, args);
    }

    @PostConstruct
    @Transactional
    void initialize() {
        for (int i = 1; i <= 10; i++) {
            LoginUser user = new LoginUser("User-" + i, "Himself-" + i, i + ".user@mytweeter.com", "12345");
            loginService.save(user);
        }
    }
}
