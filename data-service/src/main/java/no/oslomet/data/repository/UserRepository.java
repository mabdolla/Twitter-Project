package no.oslomet.data.repository;

import no.oslomet.data.models.TwitterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<TwitterUser, Long> {
}
