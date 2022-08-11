package heroku.app.demo.Services;

import heroku.app.demo.DTOs.TagDTO;
import heroku.app.demo.HResponse.HResponse;

public interface TagService {
    HResponse getAllTag(int page, int size);
    HResponse createOrUpdateTag(TagDTO dto);
}
