package school.faang.bjs2_70133;

import static school.faang.bjs2_70133.DefaultParam.DefaultInteger;
import static school.faang.bjs2_70133.DefaultParam.DefaultString;

public class Main {
    public static void main(String[] args) {
        String strResult = RemoteServiceExceptionHandler.withErrorHandling(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Service call error, return default value");
                    return DefaultString;
                }
        );

        System.out.println(strResult);

        Integer intResult = RemoteServiceExceptionHandler.withErrorHandling(
                () -> RemoteService.call(15),
                e -> {
                    System.out.println("Service call error, return default value");
                    return DefaultInteger;
                }
        );

        System.out.println(intResult);
    }

    public static class RemoteService {
        public static <T> T call(T param) {
            throw new RuntimeException("Service unavailable");
        }
    }
}
