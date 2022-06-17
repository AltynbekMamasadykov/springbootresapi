package peaksoft.springbootresapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.springbootresapi.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
