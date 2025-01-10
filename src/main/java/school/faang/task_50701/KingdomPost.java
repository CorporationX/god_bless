package school.faang.task_50701;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class KingdomPost {
    private final ExecutorService executor = Executors.newFixedThreadPool(2);

    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("The kingdom {} sent a raven to {}", sender.getName(), receiver.getName());
                if (new Random().nextBoolean()) {
                    throw new RuntimeException("The raven got lost on the way to " + receiver.getName());
                }
                sender.sendMessage(receiver);
                return "Message successfully delivered from" + sender.getName() + " to " + receiver.getName();
            } catch (RuntimeException e) {
                throw new CompletionException(e);
            }
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
