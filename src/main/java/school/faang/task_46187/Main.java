package school.faang.task_46187;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<String> remoteServiceCall = () -> {
            throw new RuntimeException("Ошибка при вызове сервиса");
        };

        String result = ErrorHandler.withErrorHandling(remoteServiceCall,
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }
}
