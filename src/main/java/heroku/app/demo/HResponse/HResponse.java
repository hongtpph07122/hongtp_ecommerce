package heroku.app.demo.HResponse;

import heroku.app.demo.Exceptions.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HResponse<T> {
    private int code;
    private String message;
    private T data;

    //build Response with Data
    public static HResponse buildHResponse(Object data) {
        HResponse hRespons = new HResponse<>();
        hRespons.setData(data);
        hRespons.setCode(200);
        hRespons.setMessage("success!");
        return hRespons;
    }
    //
    public static HResponse buildHResponse(Object data, String message){
        HResponse hResponse = new HResponse<>();
        hResponse.setMessage(message);
        hResponse.setCode(200);
        hResponse.setData(data);
        return hResponse;
    }
    //build Response with errorMessage
    public static HResponse<String> buildHResponse(ErrorMessage errorMessage) {
        HResponse<String> hResponse = new HResponse<>();
        hResponse.setCode(errorMessage.getErrorCode());
        hResponse.setMessage(errorMessage.getMessage());
        return hResponse;
    }
    // build Response with data and errorMessage
    public static <T> HResponse<T> buildHResponse(T data, ErrorMessage errorMessage) {
        HResponse<T> hResponse = new HResponse<>();
        hResponse.setCode(errorMessage.getErrorCode());
        hResponse.setMessage(errorMessage.getMessage());
        hResponse.setData(data);
        return hResponse;
    }
    public static ResponseEntity buildDeninedPermission() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json");
        ResponseEntity respEntity = new ResponseEntity(
                "You don't have permision to run this function, please contact Administrator!", responseHeaders,
                HttpStatus.BAD_REQUEST);
        return respEntity;
    }
}
