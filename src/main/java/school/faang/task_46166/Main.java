package school.faang.task_46166;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        ThrowableFunction<String, String, Exception> functionCall = RemoteService::call;

        String result = ErrorHandler.withErrorHandling(functionCall, "someParam", e -> {
            logger.error("Ошибка при вызове сервиса, возвращаем дефолтное значение");
            return "DEFAULT";
        });

        logger.info(result);
    }

    // Пример метода для удалённого сервиса
    public static class RemoteService {
        public static String call(String param) throws Exception {
            // Здесь возникнет ошибка для демонстрации
            throw new Exception("Сервис недоступен");
        }
    }

}
