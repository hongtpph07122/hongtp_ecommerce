package heroku.app.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table( name = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column ( name = "name" )
    private String name;
    @Column ( name = "description" )
    private String description;
    @Column ( name = "parentId")
    private Long parentId;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

}
