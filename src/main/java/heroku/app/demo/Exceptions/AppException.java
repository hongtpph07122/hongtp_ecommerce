package heroku.app.demo.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AppException extends RuntimeException{
    private ErrorMessage errorMessage;
}
