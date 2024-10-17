package school.faang.BJS2_33602;

public class Main {
    public static void main(String[] args) {
        RemoteService service = new RemoteService();

        String result = ErrorHandler.withErrorHandling(
            () -> {
                try {
                    return service.call("someParam");
                } catch (Exception e) {
                    throw new RuntimeException(e);  // Преобразуем Exception в RuntimeException
                }
            },
            e -> {
                System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                return "DEFAULT";
            }
        );

        System.out.println(result);
    }
}
