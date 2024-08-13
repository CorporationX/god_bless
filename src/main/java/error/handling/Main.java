package error.handling;

import java.util.function.Supplier;

public class Main {
    private static final String DEFAULT_DATA = "Default";

    public static void main(String[] args) {
        System.out.println("Полученные данные: " + getDataById(2));
        System.out.println("Полученные данные: " + getDataById(1));
    }

    static <T> T withErrorHandling(Supplier<T> action, ExceptionHandler<T> onError) {
        try {
            return action.get();
        } catch (Exception exception) {
            return onError.handle(exception);
        }
    }

    static String getDataById(Integer id) {
        return withErrorHandling(() -> findExternalData(id), (exception) -> {
            System.err.printf("Опять какая-то ошибка... [%s]", exception.getMessage()).println();
            return DEFAULT_DATA;
        });
    }

    private static String findExternalData(Integer id) {
        if (id == 1) {
            throw new IllegalArgumentException("Дата не найдена");
        }

        return "Нужная дата";
    }
}
