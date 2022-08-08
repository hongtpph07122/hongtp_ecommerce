package heroku.app.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    @Column ( name = "parent_id")
    private Long parent_id;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;
}
