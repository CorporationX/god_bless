package ravens_letter;

import java.util.concurrent.CompletableFuture;

public class RavenServis {
    public CompletableFuture<String> sendRaven (Kingdom sender, Kingdom receiver){
        return CompletableFuture.supplyAsync(() -> {
            try {
                return sender.sendMessage(receiver);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        });
    }
}
