package peaksoft.springbootresapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.springbootresapi.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
