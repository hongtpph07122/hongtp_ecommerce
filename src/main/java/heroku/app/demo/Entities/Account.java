package heroku.app.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table( name= "account" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( name= "username" , nullable = false, unique = true)
    private String username;
    @Column( name = "password", nullable = false)
    private String password;
    @Column( name = "fullname")
    private String fullname;
    @Column( name = "phoneNumber", nullable = false, unique = true)
    private String phoneNumber;
    @Column( name = "image")
    private String image;
    @Column( name = "isActive")
    private int isActive;
    @JsonIgnore
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable( name = "account_role", joinColumns = @JoinColumn(name = "accountId"), inverseJoinColumns = @JoinColumn( name = "roleId"))
    private List<Role> roles;
}
