package heroku.app.demo.Services;

import heroku.app.demo.HResponse.HResponse;

public interface CategoryService {
    HResponse getAllCategory(int page, int size);
}
