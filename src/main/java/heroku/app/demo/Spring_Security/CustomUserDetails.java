package heroku.app.demo.Spring_Security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import heroku.app.demo.Entities.Account;
import heroku.app.demo.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
    private String username;
    @JsonIgnore
    private String password;
    private String fullname;
    private String phone_number;
    private String image;
    private int is_active;
    private Collection<? extends GrantedAuthority> authorities;

    public static CustomUserDetails build(Account account, Set<Role> roles) {
        List<GrantedAuthority> authorities = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
        return new CustomUserDetails(
                account.getUsername(),
                account.getPassword(),
                account.getFullname(),
                account.getPhoneNumber(),
                account.getImage(),
                account.getIsActive(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
