package heroku.app.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "material")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Material {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column ( name = "name" )
    private String name;
    @Column ( name = "description" )
    private String description;
    @OneToMany( mappedBy = "material", cascade = CascadeType.ALL)
    private List<Product> products;
}
