package heroku.app.demo.Exceptions;

public enum ErrorMessage {
    BAD_REQUEST(400, "bad_request"),
    CLASS_NOT_EXIST ( 40401, "class_not_exist"),
    UNKNOW_ERROR( 500, "unknow_error")
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
