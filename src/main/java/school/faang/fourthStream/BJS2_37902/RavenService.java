package school.faang.fourthStream.BJS2_37902;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class RavenService {
    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();
    private static final int TERMINATION_SECONDS = 30;


    public CompletableFuture<Void> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.runAsync(() -> {
                    try {
                        sender.sendMessage(receiver);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }, EXECUTOR)
                .handle((result, exception) -> {
                    if (exception != null) {
                        log.error("Ошибка: {}", exception.getMessage());
                    } else {
                        System.out.println(result);
                    }
                    return null;
                });
    }

    public void shutdown() {
        EXECUTOR.shutdown();
        try {
            if (!EXECUTOR.awaitTermination(TERMINATION_SECONDS, TimeUnit.SECONDS)) {
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Поток был прерван", e);
            Thread.currentThread().interrupt();
        }
    }
}
