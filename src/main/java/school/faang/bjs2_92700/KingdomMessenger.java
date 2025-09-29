package school.faang.bjs2_92700;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Supplier;

@Slf4j
@Getter
public class KingdomMessenger {
    private static final int RAVEN_FLYING_DURATION = 5;
    private static final int THREAD_AMOUNT = 4;
    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);

    void sendRaven(Kingdom sender, Kingdom receiver) {
        CompletableFuture.supplyAsync(supplyAsync(sender, receiver), executor)
                .handle(handleError(sender, receiver));
    }

    private Supplier<Void> supplyAsync(Kingdom sender, Kingdom receiver) {
        return () -> {
            log.info("{} пишет...", sender.getName());
            if (Objects.equals(sender.getName(), "Хазарский Каганат")
                    && Objects.equals(receiver.getName(), "Киевская Русь")) {
                throw new RuntimeException();
            }
            try {
                TimeUnit.SECONDS.sleep(RAVEN_FLYING_DURATION);
                log.info("Новое сообщение от {} для {}.", sender.getName(), receiver.getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Ворон от {} к {} не долетел, его поймали средневековые хаккеры.",
                        sender.getName(), receiver.getName());
            }
            return null;
        };
    }

    private BiFunction<Void, Throwable, Void> handleError(Kingdom sender, Kingdom receiver) {
        return (result, e) -> {
            if (e != null) {
                log.error("{} в черном списке у {}, сообщение не доставлено, ворон был сбит лаптем.",
                        sender.getName(), receiver.getName());
            }
            return null;
        };
    }
}
