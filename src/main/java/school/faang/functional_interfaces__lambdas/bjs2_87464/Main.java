package school.faang.functional_interfaces__lambdas.bjs2_87464;


public class Main {
    public static void main(String[] args) {
        // Пример с вызовом удаленного сервиса
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("element1"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return e.getMessage();
                }
        );
        System.out.println(result);

        result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("element2"),
                e -> {
                    System.out.println("Ошибка канала связи, попробуйте еще раз");
                    return e.getMessage();
                }
        );
        System.out.println(result);

        result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("element3"),
                e -> {
                    System.out.println("Ошибка канала связи, попробуйте еще раз");
                    return e.getMessage();
                }
        );
        System.out.println(result);

    }

}
