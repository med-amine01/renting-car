package de.tekup.locationappb.repositories;

import de.tekup.locationappb.entites.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client,Integer> {
    Optional<Client> findByCin(String cin);
    @Query(nativeQuery = true,value =
    "select * from client where cin = :cin")
    Client locByCin(@Param("cin") String cin);

}
