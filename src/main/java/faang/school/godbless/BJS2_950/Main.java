package faang.school.godbless.BJS2_950;

import java.util.function.Supplier;

public class Main {
    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> exceptionHandler){
        try {
            return supplier.get();
        } catch (Exception e) {
            return exceptionHandler.handle(new Exception("Не удалось получить доступ к Remote Service. Вернем default значение"));
        }
    }
}
