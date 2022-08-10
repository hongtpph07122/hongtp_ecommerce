package heroku.app.demo.Services;

import heroku.app.demo.DTOs.AccountDTO;
import heroku.app.demo.HResponse.HResponse;

public interface AccountService {
    HResponse signupAccountClient(AccountDTO dto);
}
