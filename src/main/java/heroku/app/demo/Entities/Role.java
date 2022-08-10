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
@Table ( name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column ( name = "roleName" )
    private String roleName;
    @Column ( name = "description" )
    private String description;
    @JsonIgnore
    @ToString.Exclude
    @ManyToMany( mappedBy = "roles")
    private List<Account> accounts;

}
