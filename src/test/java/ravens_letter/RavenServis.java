package ravens_letter;

import java.util.concurrent.CompletableFuture;

public class RavenServis {
    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return sender.sendMessage(receiver);
            } catch (Exception e) {
                throw new IllegalStateException("Failed to send message via raven frome "
                        + sender.getName() + "to" + receiver.getName(), e);
            }
        });
    }
}
