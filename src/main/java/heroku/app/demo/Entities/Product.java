package heroku.app.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table( name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private Long id;
    @Column ( name = "name" )
    private String name;
    @Column ( name = "description" )
    private String description;
    @Column( name = "image")
    private String image;
    @ManyToOne
    @JoinColumn( name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn( name = "material_id")
    private Material material;
    @ManyToOne
    @JoinColumn( name = "tag_id")
    private Tag tag;
}
