package net.BuildUi.Authservice.repositories;

import net.BuildUi.Authservice.entities.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserRepository extends CrudRepository<UserInfo , String> {
    UserInfo findByUsername(String username);
}
