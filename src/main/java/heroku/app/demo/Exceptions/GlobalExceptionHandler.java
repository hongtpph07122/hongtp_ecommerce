package heroku.app.demo.Exceptions;

import heroku.app.demo.HResponse.HResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<HResponse> handlerUnwantedException(Exception ex) {
        // Log lỗi ra và ẩn đi message thực sự
        return ResponseEntity.status(200).body(HResponse.buildHResponse(ErrorMessage.UNKNOW_ERROR));
    }
    @ExceptionHandler(AppException.class)
    public ResponseEntity<HResponse> handlerAppException(AppException e){
        return ResponseEntity.status(200).body(HResponse.buildHResponse(e.getErrorMessage()));
    }
}
