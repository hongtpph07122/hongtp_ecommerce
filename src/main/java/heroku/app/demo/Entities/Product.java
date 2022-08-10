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
    @JoinColumn( name = "categoryId")
    private Category category;
    @ManyToOne
    @JoinColumn( name = "materialId")
    private Material material;
    @ManyToOne
    @JoinColumn( name = "tagId")
    private Tag tag;
}
