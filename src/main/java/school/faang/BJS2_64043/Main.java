package school.faang.BJS2_64043;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final long SLEEP_TIME_SECONDS = (3);

    public static void main(String[] args) {

        Kingdom kingdom1 = new Kingdom("Московское");
        Kingdom kingdom2 = new Kingdom("Ростовское");

        kingdom1.sendMessage(kingdom2);

        CompletableFuture<String> future = Kingdom.sendRaven(kingdom1, kingdom2);

        future.thenAccept(System.out::println).exceptionally(ex -> {
            log.warn("Ошибка: {}", ex.getMessage());
            throw new RuntimeException("Ошибка при доставке сообщения", ex);
        });

        try {
            TimeUnit.SECONDS.sleep(SLEEP_TIME_SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException("Ошибка ", e);
        }
    }
}