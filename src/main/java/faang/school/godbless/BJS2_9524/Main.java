package faang.school.godbless.BJS2_9524;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Supplier<String> action = () -> {
            System.out.println("Connecting to server...");

            // случайно выбрасывается ошибка
            if (Math.random() + 1 > 1.3) {
                throw new RuntimeException("Some error");
            }

            return "success";
        };

        // можно заменить ExceptionHandler на Function
        ExceptionHandler<String> handler = e -> {
            System.out.println("Couldn't connect to server\nFollowing error: " + e.getMessage() + "\nReturn default value..");
            return "Default";
        };

        String response = withErrorHandling(action, handler);

        System.out.println("Response: " + response);
    }

    // Возвращает тип указанный в дженериках
    public static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> handler) {
        T result;

        try {
            result = action.get();
        } catch (Exception e) {
            result = handler.handle(e);
        }

        return result;
    }
}
