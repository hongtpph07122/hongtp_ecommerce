package heroku.app.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "size")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Size {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column ( name = "name" )
    private String name;
    @Column ( name = "description" )
    private String description;
    @Column( name = "isActive")
    private int isActive;
    @OneToMany(mappedBy = "size", cascade = CascadeType.ALL)
    private List<ProductDetail> productDetails;
}
