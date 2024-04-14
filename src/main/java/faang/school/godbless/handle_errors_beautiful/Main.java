package faang.school.godbless.handle_errors_beautiful;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class Main {
    public static void main(String[] args) {

    }

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> errorHandling) {
        try {
            return supplier.get();
        } catch (Exception e) {
            log.warn("Не удалось получить доступ к сервису. Вернем значение обработчика ошибок");
            return errorHandling.handle(e);
        }
    }
}
