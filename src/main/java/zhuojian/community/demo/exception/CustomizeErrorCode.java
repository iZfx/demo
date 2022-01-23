package zhuojian.community.demo.exception;

/**
 * Created by iZfx on 2022/1/23 22:40
 */
public enum CustomizeErrorCode implements InterCustomizeErrorCode {
    QUESTION_NOT_FOUND("该页面不存在，要不换个试试？");

    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
