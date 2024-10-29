package school.faang.sendraven;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class MessagingSystem {
    private static final int NUM_THREADS = 5;
    private static final int RAVEN_FLIGHT_TIME = 1000;
    private static final ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

    public void sendRaven(Kingdom sender, Kingdom receiver) {
        CompletableFuture<String> sendingMessage = CompletableFuture.supplyAsync(() -> {
                    try {
                        Thread.sleep(RAVEN_FLIGHT_TIME);
                    } catch (InterruptedException e) {
                        log.error("Caught exception: {}", e);
                    }
                    return sender.sendMessage(receiver);
                }, executor)
                .handle((result, ex) -> {
                    if (ex != null) {
                        log.error("Caught exception: {}", ex);
                    }
                    return result;
                });
        String result = sendingMessage.join();
        log.info(result);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
