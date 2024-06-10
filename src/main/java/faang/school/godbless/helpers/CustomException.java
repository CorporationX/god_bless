package faang.school.godbless.helpers;

import java.util.Arrays;

public class CustomException extends Exception{
    public CustomException() {
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(Throwable cause) {
        super(cause);
    }

    public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    public void printError(){
        System.out.println(this.getMessage());
        Arrays.stream(this.getStackTrace()).forEach(System.out::println);
    }
}
