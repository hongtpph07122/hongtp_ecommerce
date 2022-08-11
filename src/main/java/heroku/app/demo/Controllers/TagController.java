package heroku.app.demo.Controllers;

import heroku.app.demo.DTOs.CategoryDTO;
import heroku.app.demo.DTOs.TagDTO;
import heroku.app.demo.Services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TagController {
    @Autowired
    TagService tagService;
    @GetMapping(value = "/tags")
    public ResponseEntity<?> getAllTag(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        return ResponseEntity.ok(tagService.getAllTag(page, size));
    }

    @PostMapping( value = "/tags")
    public ResponseEntity<?> createOrUpdateTag(@RequestBody TagDTO dto) {
        return ResponseEntity.ok(tagService.createOrUpdateTag(dto));
    }
}
