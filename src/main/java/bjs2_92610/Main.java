package bjs2_92610;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        RavenService ravenService = new RavenService();

        List<Kingdom> kingdoms = List.of(
                new Kingdom("Винтерфелл"),
                new Kingdom("Королевская Гавань"),
                new Kingdom("Хайгарден"),
                new Kingdom("Дорн"),
                new Kingdom("Долина Арренов"),
                new Kingdom("Железные Острова"),
                new Kingdom("Штормовой Предел")
        );

        AtomicInteger totalMessages = new AtomicInteger(0);

        kingdoms.stream()
                .flatMap(from -> kingdoms.stream()
                        .filter(to -> !to.equals(from))
                        .map(to -> {
                            totalMessages.incrementAndGet();
                            return ravenService.sendRaven(from, to)
                                    .handle((result, exception) -> {
                                        if (exception != null) {
                                            System.out.println("Ошибка: " + exception.getMessage());
                                        } else {
                                            System.out.println(result);
                                        }
                                        return null;
                                    });
                        })
                )
                .forEach(CompletableFuture::join);

        System.out.println("\nВсего попыток отправки воронов: " + totalMessages.get());
    }
}