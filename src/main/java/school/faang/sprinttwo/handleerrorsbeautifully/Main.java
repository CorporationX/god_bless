package school.faang.sprinttwo.handleerrorsbeautifully;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("\nВызываем сервис....");
        String result = ErrorHandler.withErrorHandling(
                () -> RemoteService.call("ТЕЛО ВЫЗОВА"),
                e -> {
                    System.out.printf("%s Ошибка при вызове сервиса, возвращаем дефолтное значение\n".formatted(e));
                    return "DEFAULT";
                }
        );

        System.out.println(result);
    }

    public static class RemoteService {
        public static String call(String param) {
            throw new RuntimeException("%s \n Iзвините!!! В пятницу сервис недоступен. Отдыхайте.".formatted(param));
        }
    }
}