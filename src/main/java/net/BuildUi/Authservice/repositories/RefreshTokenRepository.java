package net.BuildUi.Authservice.repositories;

import net.BuildUi.Authservice.entities.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken , Integer> {
    Optional<RefreshToken> findByToken(String token);
}
