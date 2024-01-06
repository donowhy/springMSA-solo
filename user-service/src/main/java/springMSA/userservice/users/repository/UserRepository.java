package springMSA.userservice.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springMSA.userservice.users.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findbyUserId(String userId);
}
