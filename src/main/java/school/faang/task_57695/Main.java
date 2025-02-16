package school.faang.task_57695;

public class Main {
    public static void main(String[] args) {
        String result = ErrorHandler.withErrorHandling(
                () -> {
                    return "Success!";
                },
                e -> {
                    System.out.println("Произошла ошибка: " + e.getMessage());
                    return "Ошибка"; // Возвращаем значение по умолчанию
                }
        );
        System.out.println("Результат: " + result);

        // Пример с исключением
        String errorResult = ErrorHandler.withErrorHandling(
                () -> {
                    throw new RuntimeException("Что-то пошло не так!");
                },
                e -> {
                    System.out.println("Произошла ошибка: " + e.getMessage());
                    return "Ошибка";
                }
        );
        System.out.println("Результат: " + errorResult);
    }
}