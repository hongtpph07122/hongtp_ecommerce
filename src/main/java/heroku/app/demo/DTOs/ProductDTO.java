package heroku.app.demo.DTOs;

import heroku.app.demo.Entities.Category;
import heroku.app.demo.Entities.Material;
import heroku.app.demo.Entities.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private String image;
    private int isActive;
    private CategoryDTO category;
    private MaterialDTO material;
    private TagDTO tag;
}
