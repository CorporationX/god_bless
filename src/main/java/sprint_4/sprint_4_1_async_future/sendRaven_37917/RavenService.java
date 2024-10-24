package sprint_4.sprint_4_1_async_future.sendRaven_37917;

import java.util.concurrent.CompletableFuture;

public class RavenService {
    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return sender.sendMessage(receiver);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        });
    }
}
