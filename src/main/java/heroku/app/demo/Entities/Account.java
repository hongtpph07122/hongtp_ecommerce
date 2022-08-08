package heroku.app.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @Column( name = "phone_number", nullable = false, unique = true)
    private String phone_number;
    @Column( name = "image")
    private String image;
}
