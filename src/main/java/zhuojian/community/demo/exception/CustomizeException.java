package zhuojian.community.demo.exception;

/**
 * Created by iZfx on 2022/1/23 21:46
 */
public class CustomizeException extends RuntimeException {
    private String message;

    public CustomizeException(InterCustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    public CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
