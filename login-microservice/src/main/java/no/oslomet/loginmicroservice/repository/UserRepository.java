package no.oslomet.loginmicroservice.repository;

import no.oslomet.loginmicroservice.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<LoginUser, Long> {
    Optional<LoginUser> findUserByEmail(String email);
}
