import lombok.AllArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@AllArgsConstructor
public class Kingdom {
    private String name;

    public CompletableFuture<String> sendMessage(Kingdom kingdom) throws RuntimeException {
        var future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (Math.random() < 0.5) {
                return "Message to %s has been delivered".formatted(kingdom.name);
            } else {
                throw new RuntimeException("deliver is failed");
            }
        });
        return future;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Kingdom kingdom1 = new Kingdom("Kingdom 1");
        Kingdom kingdom2 = new Kingdom("Kingdom 2");
        var message = sendRaven(kingdom1, kingdom2);
        System.out.println(message.get());
    }

    public static CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        var result = sender.sendMessage(receiver);
        return result.handle((message, exception) -> {
            if (message != null) {
                return message;
            } else {
                return exception.getMessage();
            }
        });
    }
}

