package heroku.app.demo.Repositories;

import heroku.app.demo.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);
    Account findByPhoneNumber(String phoneNumber);
}
