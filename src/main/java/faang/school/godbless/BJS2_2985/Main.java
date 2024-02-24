package faang.school.godbless.BJS2_2985;


import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println(someDangerousAction(0));
        System.out.println(someDangerousAction(1));
        System.out.println(anotherDangerousAction(0));
        System.out.println(anotherDangerousAction(1));

    }

    static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return exceptionHandler.handle(e);
        }
    }

    static String someDangerousAction(Integer param) {
        RemoteService remoteService = new RemoteService();
        try {
            return remoteService.call(param);
        } catch (Exception e) {
            System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение");
            return "DEFAULT";
        }
    }

    static String anotherDangerousAction(Integer param) {
        RemoteService remoteService = new RemoteService();
        return withErrorHandling(() -> remoteService.call(param), (exception) -> {
            System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение");
            return "DEFAULT";
        });
    }
}