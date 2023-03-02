package ir.dotin.registration.repository;

import ir.dotin.registration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {


    User save(User user);

    Optional<User> findById(UUID id);

    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByEmail(String email);


}
