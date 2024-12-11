package school.faang.bjs246171;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> {
                    try {
                        return RemoteService.call("Some parameter");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                },
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
        System.out.println(result);
    }

    //    public static void main(String[] args) {
    //    String result = ErrorHandler.withErrorHandling(
    //            () -> RemoteService.call("Some parameter"),
    //            e -> {
    //              System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
    //              return "DEFAULT";
    //           }
    //    );
    //    System.out.println(result);
    //    }
}
