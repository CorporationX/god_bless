package HandleErrorsBeautifully;

import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Main {

    public static void main(String[] args) {

        Supplier<String> taskWithException = () -> {
            System.out.println("Executing service");
            throw new RuntimeException() ;
        };
        System.out.println(handleError(taskWithException, exception -> "DEFAULT"));

        Supplier<String> taskWithoutException = () -> {
            System.out.println("Executing service");
            return "OK";
        };
        System.out.println(handleError(taskWithoutException, exception -> "DEFAULT"));
    }

    private static <T> T handleError(Supplier<T> function, ExceptionHandler<T> exception){
        try {
            return function.get();
        } catch (Exception e) {
            log.warn("Не удалось получить доступ к Remote Service. Вернем default значение");
            return exception.handle(e);
        }
    }
}
