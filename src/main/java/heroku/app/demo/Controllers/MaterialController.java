package heroku.app.demo.Controllers;

import heroku.app.demo.DTOs.MaterialDTO;
import heroku.app.demo.DTOs.TagDTO;
import heroku.app.demo.Services.MaterialService;
import heroku.app.demo.Services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MaterialController {
    @Autowired
    MaterialService materialService;
    @GetMapping(value = "/materials")
    public ResponseEntity<?> getAllMaterial(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ){
        return ResponseEntity.ok(materialService.getAllMaterial(page, size));
    }

    @PostMapping( value = "/materials")
    public ResponseEntity<?> createOrUpdateMaterial(@RequestBody MaterialDTO dto) {
        return ResponseEntity.ok(materialService.createOrUpdateMaterial(dto));
    }
}
