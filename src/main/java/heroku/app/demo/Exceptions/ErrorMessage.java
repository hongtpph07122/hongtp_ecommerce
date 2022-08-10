package heroku.app.demo.Exceptions;

public enum ErrorMessage {
    BAD_REQUEST(400, "bad_request"),
    UNKNOW_ERROR( 500, "unknow_error"),
    ROLE_NOT_FOUND(40401, "role_not_found"),
    ROLE_EMPTY(40402, "role_empty"),
    CATEGORY_NOT_EXIST(40403, "category_not_exist")
    ;





    private int errorCode;
    private String message;
    ErrorMessage (int pCode, String pMessage) {
        errorCode = pCode;
        message = pMessage;
    }
    public int getErrorCode() {
        return errorCode;
    }
    public String getMessage(){
        return message;
    }


}
