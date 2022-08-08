package heroku.app.demo.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table( name = "product_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    @Column( name = "name")
    private String name;
    @Column( name = "price")
    private double price;
    @Column( name = "image")
    private String image;
    @ManyToOne
    @JoinColumn( name = "size_id")
    private Size size;
    @ManyToOne
    @JoinColumn( name = "color_id")
    private Color color;


}
