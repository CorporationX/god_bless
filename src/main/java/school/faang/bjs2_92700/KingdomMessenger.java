package school.faang.bjs2_92700;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class KingdomMessenger {
    static final int RAVEN_FLYING_DURATION = 5;
    static final int THREAD_AMOUNT = 4;
    static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(THREAD_AMOUNT);

    public static void sendRaven(Kingdom sender, Kingdom receiver) {
        CompletableFuture.supplyAsync(() -> {
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
            return "Получено новое сообщение";
        }, EXECUTOR).handle((result, e) -> {
            if (e != null) {
                log.error("{} в черном списке у {}, сообщение не доставлено, ворон был сбит лаптем.",
                        sender.getName(), receiver.getName());
                return "";
            } else {
                return "Наше вам с кисточкой, соседи!";
            }
        });
    }
}
