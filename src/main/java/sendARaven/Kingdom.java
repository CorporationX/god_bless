package sendARaven;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
@Data
public class Kingdom {
    private static final int AMOUNT_OF_THREADS = 5;
    private static final ExecutorService SERVICE = Executors.newFixedThreadPool(AMOUNT_OF_THREADS);
    private String name;

    public CompletableFuture<String> sendMessage(Kingdom kingdom) {
        return CompletableFuture.runAsync(() -> {
                    System.out.printf("\n%s send message to %s", this.getName(), kingdom.getName());
                    try {
                        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, SERVICE)
                .handle((result, error) -> {
                    if (error != null) {
                        return "\nRaven did not deliver the message";
                    }
                    return "\nMessage delivered";
                });
    }

    public static void shutdown() {
        SERVICE.shutdown();
    }
}
