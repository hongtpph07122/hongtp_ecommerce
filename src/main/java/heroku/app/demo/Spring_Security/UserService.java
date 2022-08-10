package heroku.app.demo.Spring_Security;

import heroku.app.demo.Entities.Account;
import heroku.app.demo.Entities.Role;
import heroku.app.demo.Repositories.AccountRepository;
import heroku.app.demo.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    RoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if(account == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        Set<Role> roles = roleRepository.findRolesByAccount(account.getId());
        UserDetails userDetails = CustomUserDetails.build(account, roles);
        return userDetails;
    }
}
