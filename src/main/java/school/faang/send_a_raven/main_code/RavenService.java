package school.faang.send_a_raven.main_code;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RavenService {
    private static final int THREAD_COUNT = 4;

    private ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);

    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return sender.sendMessage(receiver);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }, service);
    }

    public void shutdown() {
        service.shutdown();
    }
}
