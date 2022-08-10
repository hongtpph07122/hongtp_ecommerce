package heroku.app.demo.DTOs;

import heroku.app.demo.Entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private String username;
    private String password;
    private String image;
    private String phoneNumber;
    private String fullname;
    private Set<String> roles;
}
