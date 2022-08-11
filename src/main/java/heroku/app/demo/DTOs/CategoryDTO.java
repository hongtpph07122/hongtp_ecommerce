package heroku.app.demo.DTOs;

import heroku.app.demo.Entities.Category;
import heroku.app.demo.Entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
    private String description;
    private Long parentId;
    private int isActive;
    private Set<CategoryDTO> childCategory;
    private List<ProductDTO> products;

}
