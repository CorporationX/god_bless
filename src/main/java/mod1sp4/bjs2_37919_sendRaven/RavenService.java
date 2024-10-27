package mod1sp4.bjs2_37919_sendRaven;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class RavenService {
    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();

    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return sender.sendMessage(receiver);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }, EXECUTOR);
    }

    public static void shuttingDownExecutor() {
        EXECUTOR.shutdown();
        try {
            if (!EXECUTOR.awaitTermination(1, TimeUnit.MINUTES)) {
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Error shutting down executor: {}", e.getMessage());
            throw new IllegalStateException(e);
        }
    }
}
