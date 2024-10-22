package school.faang.send_crow_BJS2_37899;

import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
public class Kingdom {
    private String name;

    public void sendMessage(Kingdom receiver) throws Exception {
        final double EXCEPTION_CHANCE = 0.3;
        if (Math.random() <= EXCEPTION_CHANCE) {
            throw new Exception("Raven of " + name + " was killed by enemy's archers");
        } else {
            System.out.printf("Raven delivered message from %s to %s\n", name, receiver.name);
        }
    }

    public static CompletableFuture<Void> sendRaven(Kingdom sender, Kingdom receiver) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                sender.sendMessage(receiver);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }, executor);
        executor.shutdown();
        return future;
    }
}
