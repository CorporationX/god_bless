package faang.BJS2_70175;

import java.util.Random;

public final class Main {
    public static void main(final String[] args) {
        final String result = handlerError();
        System.out.println(result);
    }

    private static String handlerError() {
        return ErrorHandler.withErrorHandler(
                () -> RemoteService.call("someParam"),
                e -> {
                    System.out.println("Ошибка при вызове сервиса, возвращаем дефолтное значение");
                    return "DEFAULT";
                }
        );
    }

    private static class RemoteService {
        private static String call(final String param) {
            final Random random = new Random();

            if (random.nextBoolean()) {
                return param;
            }

            throw new RuntimeException("Сервис недоступен");
        }
    }
}
