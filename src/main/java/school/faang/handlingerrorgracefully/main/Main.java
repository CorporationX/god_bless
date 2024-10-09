package school.faang.handlingerrorgracefully.main;

import school.faang.handlingerrorgracefully.maincode.ErrorHandler;
import school.faang.handlingerrorgracefully.maincode.RemoteService;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("someParam"), e -> {
                    System.out.println("Ошибка при вызове сервиса");
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }
}
