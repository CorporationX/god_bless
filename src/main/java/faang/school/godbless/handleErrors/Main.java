package faang.school.godbless.handleErrors;

import java.util.function.Supplier;

public class Main {

    private static RemoteService remoteService = new RemoteService();

    public static <T> T withErrorHandling(Supplier<T> toDo, ExceptionHandler<T> exceptionHandler){
        try {
            return toDo.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }

    public static void main(String[] args) {
        int paramToCallRemoteService = 10;
        String result = withErrorHandling(
                () -> remoteService.call(paramToCallRemoteService),
                (e) -> {
                    System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }
}
