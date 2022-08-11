package heroku.app.demo.Services;

import heroku.app.demo.DTOs.MaterialDTO;
import heroku.app.demo.HResponse.HResponse;

public interface MaterialService {
    HResponse getAllMaterial(int page, int size);
    HResponse createOrUpdateMaterial(MaterialDTO dto);
}
