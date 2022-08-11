package heroku.app.demo.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialDTO {
    private Long id;
    private String name;
    private String description;
    private int isActive;
    private List<ProductDTO> products;
}
