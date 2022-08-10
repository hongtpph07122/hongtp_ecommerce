package heroku.app.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "color")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Color {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column( name = "name" )
    private String name;
    @Column ( name = "hexCode" )
    private String hexCode;
    @OneToMany( mappedBy = "color", cascade = CascadeType.ALL)
    private List<ProductDetail> productDetails;
}
