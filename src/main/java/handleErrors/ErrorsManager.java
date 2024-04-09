package handleErrors;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ErrorsManager {
    public static <T> T withErrorHandling(Supplier<T> returnMeaning, ExceptionHandler<T> handler) {
        try {
            return returnMeaning.get();
        } catch (Exception e) {
            System.out.println("Не удалось получить доступ к Remote Service. Вернем default значение");
            return handler.handle(e);
        }
    }
}
