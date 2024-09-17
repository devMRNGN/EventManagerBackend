package backend.fatec.repositories;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import backend.fatec.models.User;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
    /**
     *  Checa se ja existe um usuário com esse email ou esse username
     * 
     * @param String username;
     * @param String email;
     * @return User ; or null
     * 
    */
    @Query("SELECT u FROM User u WHERE u.username = :USERNAME OR u.email = :EMAIL")
    List<Optional<User>> checkIfUserExists(
        @Param("USERNAME") String username,
        @Param("EMAIL") String email
    );

    Optional<User> findByEmail(String email);
}