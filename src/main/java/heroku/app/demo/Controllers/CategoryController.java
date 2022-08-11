package heroku.app.demo.Controllers;

import heroku.app.demo.DTOs.CategoryDTO;
import heroku.app.demo.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping( "/categorys" )
    public ResponseEntity<?> getAllCategory(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        return ResponseEntity.ok(categoryService.getAllCategory(page, size));
    }
    @PostMapping("/categorys")
    public ResponseEntity<?> createOrUpdateCategory(@RequestBody CategoryDTO dto) {
        return ResponseEntity.ok(categoryService.createOrUpdateCategory(dto));
    }
}
