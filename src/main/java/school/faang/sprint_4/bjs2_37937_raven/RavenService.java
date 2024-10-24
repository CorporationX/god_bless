package school.faang.sprint_4.bjs2_37937_raven;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class RavenService {
    public CompletableFuture<String> sendRaven(Kingdom sender, Kingdom receiver) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return sender.sendMessage(receiver);
            } catch (Exception e) {
                log.error("An error occurred while sending message", e);
                throw new RuntimeException(e);
            }
        });
    }
}
