package faang.school.godbless.BJS2_21119;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("one", "two", "thee");
        String string = withErrorHandling(() -> strings.get(0), (e) -> {
            System.out.println(e.getMessage());
            return "Error";
        });
        System.out.println(string);
    }

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> onError) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return onError.handle(e);
        }
    }

}
