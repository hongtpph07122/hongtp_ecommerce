package heroku.app.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "tag")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column( name = "name", unique = true)
    private String name;
    @Column ( name = "description" )
    private String description;
    @Column( name = "isActive")
    private int isActive;
    @OneToMany( mappedBy = "tag", cascade = CascadeType.ALL)
    private List<Product> products;
}
