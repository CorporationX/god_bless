package school.faang.task418.got;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
public class Kingdom {
    private String name;

    public CompletableFuture<String> sendMessage(Kingdom receiver) {
        return sendRaven(this, receiver);
    }

    private final ExecutorService service = Executors.newFixedThreadPool(2);

    private CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
            if (Math.random() > 0.8) {
                throw new IllegalStateException("Ворон умер по пути");
            } else {
                return "Ворон успешно долетел до королевства " + receiver.getName();
            }
        }, service);
    }

    public void shutdown() {
        service.shutdown();
        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Ошибка в работе воронов");
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
