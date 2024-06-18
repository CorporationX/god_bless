package faang.school.godbless.BJS2_9579;

import java.util.Random;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        var pp = withErrorHandling(() -> remoteMethod(), (e) -> {
            System.out.println(e.getMessage() + ". Вернем default значение");
            return 1;
        });
        System.out.println(pp);
    }

    public static <T> T withErrorHandling(Supplier<T> supplier, ExceptionHandler<T> handler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            return handler.handle(e);
        }
    }

    public static int remoteMethod() {
        int a = new Random().nextInt(2);
        if (a == 1) {
            throw new RuntimeException("Рандом выдал 1, ошибка");
        }
        return a;
    }
}
