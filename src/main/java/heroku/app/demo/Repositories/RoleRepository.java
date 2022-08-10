package heroku.app.demo.Repositories;

import heroku.app.demo.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query( value = "SELECT r.* FROM role r JOIN account_role ur ON r.id = ur.role_id" +
            " WHERE ur.account_id = :account_id", nativeQuery = true)
    Set<Role> findRolesByAccount(@Param("account_id") Long id);
    Optional<Role> findRolesByRoleName(String roleName);
    Role findByRoleName(String roleName);
}
