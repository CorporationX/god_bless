package faang.school.godbless.BJS2_25060;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@AllArgsConstructor
public class Kingdom {
    private ExecutorService executor;
    private String name;

    public CompletableFuture<Kingdom> sendRaven(Kingdom kingdom) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.printf("Отправка сообщения из %s в %s%n", name, kingdom.name);

            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            if (ThreadLocalRandom.current().nextBoolean()) {
                throw new CompletionException(new MessageNotDeliveredException(kingdom));
            }
            return kingdom;
        }, executor);
    }
}
