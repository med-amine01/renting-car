package de.tekup.locationappb.security.repos;

import de.tekup.locationappb.security.entites.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
